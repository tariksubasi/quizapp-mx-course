import { withTiming, logMessage, logLevel } from "./logging.js";

async function navigateToPage(
    page,
    pageUrl,
    securityToken,
    requestAnalyzer,
    waitForIdleNetwork
) {
    if (page === undefined) throw new Error("Browser not initialized");

    await page.setRequestInterception(true);
    let interceptNavigationRequests = true;

    page.on("request", (request) => {
        if (
            waitForIdleNetwork === true &&
            request.url().includes("livereload.js")
        ) {
            logMessage(`Aborting request ${request.url()}`);
            return request.abort();
        }

        if (interceptNavigationRequests && request.isNavigationRequest()) {
            const headers = request.headers();
            headers["X-Security-Token"] = securityToken;
            interceptNavigationRequests = false;
            return request.continue({ headers });
        }

        return request.continue();
    });

    if (requestAnalyzer !== undefined) {
        page.on("response", (response) =>
            requestAnalyzer.analyzeResponse(response)
        );
    }

    await withTiming("Navigate to page", async () => page.goto(pageUrl)).catch(
        (error) => {
            throw new Error(`Failed to navigate to page: ${error}`);
        }
    );
}

async function waitForContent(page, waitForIdleNetwork) {
    if (page === null) throw new Error("Browser not initialized");

    const waitUntil = waitForIdleNetwork ? "networkidle0" : "networkidle2";

    await withTiming(
        `Wait for content to load using ${waitUntil} strategy`,
        async () =>
            Promise.all([
                page.waitForNavigation({ waitUntil }),
                page.waitForSelector("#content .document-content", {
                    visible: true,
                }),
            ])
    ).catch((error) => {
        throw new Error(`Failed to load page: ${error}`);
    });
}

async function emulateScreenMedia(page) {
    await withTiming("Emulate screen media", async () => {
        await page.emulateMediaType("screen");
    }).catch((error) => {
        throw new Error(`Failed to emulate screen media: ${error}`);
    });
}

async function injectClassToBodyElement(page, className) {
    await withTiming(
        `Inject class '${className}' to body element`,
        async () => {
            const bodyHandle = await page.$("body");
            if (bodyHandle !== undefined) {
                await page.evaluate(
                    (body, className) => body.classList.add(className),
                    bodyHandle,
                    className
                );
                await bodyHandle.dispose();
            }
        }
    ).catch((error) => {
        throw new Error(`Failed to inject class to body element: ${error}`);
    });
}

async function emulateTimezone(page, timezone) {
    await withTiming("Emulate timezone", async () => {
        await page.emulateTimezone(timezone);
        logMessage(`Emulating timezone: ${timezone}`);
    }).catch((error) => {
        throw new Error(`Failed to emulate timezone: ${error}`);
    });
}

async function pageOrientationIsLandscape(page) {
    if (page === null) throw new Error("Browser not initialized");

    return (
        (await withTiming("Determine page orientation", async () =>
            page.$(".page-orientation-landscape")
        )) !== null
    );
}

async function determinePageSize(page) {
    if (page === null) throw new Error("Browser not initialized");

    const allowedPageSizes = [
        "letter",
        "legal",
        "tabloid",
        "a0",
        "a1",
        "a2",
        "a3",
        "a4",
        "a5",
        "a6",
    ];

    let pageSize = await withTiming("Determine page size", async () =>
        page
            .$eval("[class*='page-size']", (node) =>
                Array.from(node.classList)
                    .find((c) => c.startsWith("page-size"))
                    .replace("page-size-", "")
            )
            .catch(() => "a4")
    );

    if (!allowedPageSizes.includes(pageSize)) {
        logMessage("Invalid page size, setting page size to A4", logLevel.warn);
        pageSize = "a4";
    }

    return pageSize;
}

async function pageNumbersEnabled(page) {
    if (page === null) throw new Error("Browser not initialized");

    return (
        (await withTiming("Determine page numbers enabled", async () =>
            page.$(".enable-page-numbers")
        )) !== null
    );
}

function getHeaderFooterOptions(enablePageNumbers) {
    const headerTemplate = "<div></div>";
    const footerTemplate =
        "<div style='width:50%'>&nbsp;</div><div style='padding-right: 5mm; width:50%; text-align:right; font-size:8px;'><span class='pageNumber'></span> / <span class='totalPages'></span></div>";

    return {
        headerTemplate: headerTemplate,
        footerTemplate: footerTemplate,
        displayHeaderFooter: enablePageNumbers,
        margin: {
            bottom: enablePageNumbers ? "10mm" : "0",
        },
    };
}

async function generateDocument(
    page,
    pageUrl,
    securityToken,
    timezone,
    useScreenMediaType,
    waitForIdleNetwork,
    requestAnalyzer
) {
    if (useScreenMediaType) await emulateScreenMedia(page);
    await emulateTimezone(page, timezone ?? "GMT");
    await navigateToPage(
        page,
        pageUrl,
        securityToken,
        requestAnalyzer,
        waitForIdleNetwork
    );
    await waitForContent(page, waitForIdleNetwork);
    await injectClassToBodyElement(page, "document-generation-body-injected");

    const isLandscape = await pageOrientationIsLandscape(page);
    const pageSize = await determinePageSize(page);
    const enablePageNumbers = await pageNumbersEnabled(page);
    const headerFooterOptions = getHeaderFooterOptions(enablePageNumbers);

    return withTiming("Export to PDF", async () =>
        page.pdf({
            preferCSSPageSize: true,
            printBackground: true,
            landscape: isLandscape,
            format: pageSize,
            ...headerFooterOptions,
        })
    ).catch((error) => {
        throw new Error(`Failed to export to PDF: ${error}`);
    });
}

async function getPageMetrics(page) {
    if (page === undefined) throw new Error("Browser not initialized");
    return page.metrics();
}

function getRequestStatistics(requestAnalyzer) {
    if (requestAnalyzer === undefined) return undefined;
    return requestAnalyzer.getStatistics();
}

export function createDocumentGenerator(browser, requestAnalyzer) {
    let page;

    return {
        initialize: async () => {
            page = await browser.openPage();
        },
        generateDocument: async (
            pageUrl,
            securityToken,
            timezone,
            useScreenMediaType,
            waitForIdleNetwork
        ) =>
            withTiming("Generate document", async () =>
                generateDocument(
                    page,
                    pageUrl,
                    securityToken,
                    timezone,
                    useScreenMediaType,
                    waitForIdleNetwork,
                    requestAnalyzer
                )
            ),
        getPageMetrics: async () => getPageMetrics(page),
        getRequestStatistics: () => getRequestStatistics(requestAnalyzer),
    };
}
