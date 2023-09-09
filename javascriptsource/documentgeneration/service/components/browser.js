import { launch } from "puppeteer-core";
import { withTiming, logMessage, logLevel } from "./logging.js";

async function initialize(chromePath) {
    return withTiming("Launch browser", async () =>
        launch({
            executablePath: chromePath,
            headless: true,
            args: ["--disable-dev-shm-usage", "--no-sandbox"],
        })
    ).catch((error) => {
        logMessage(
            `Failed to launch headless browser: ${error}`,
            logLevel.error
        );
        throw error;
    });
}

async function openPage(browser) {
    if (browser === undefined) throw new Error("Browser not initialized");
    return withTiming("Open new tab", async () => browser.newPage());
}

async function close(browser) {
    if (browser === undefined) return;
    await browser.close();
    logMessage("Closed browser");
}

export function createBrowser(chromePath) {
    let browser;

    return {
        initialize: async () => {
            browser = await initialize(chromePath);
        },
        openPage: async () => openPage(browser),
        close: async () => close(browser),
    };
}
