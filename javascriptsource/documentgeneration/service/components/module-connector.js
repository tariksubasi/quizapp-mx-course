import axios from "axios";
import { withTiming } from "./logging.js";

async function sendResult(resultUrl, document, securityToken, maxBodyLength) {
    await withTiming("Send result back", () =>
        axios({
            method: "POST",
            url: resultUrl,
            data: document,
            maxBodyLength,
            headers: {
                "Content-Type": "application/pdf",
                "X-Security-Token": securityToken,
            },
        })
    ).catch((error) => {
        throw new Error(`Failed to send result: ${error}`);
    });
}

export function createModuleConnector(maxBodyLength) {
    if (maxBodyLength === undefined || Math.sign(maxBodyLength) !== 1)
        throw new Error(`Invalid value '${maxBodyLength}' for maxBodyLength`);

    return {
        sendResult: async (resultUrl, document, securityToken) =>
            sendResult(resultUrl, document, securityToken, maxBodyLength),
    };
}
