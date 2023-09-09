export const logLevel = {
    debug: "debug",
    info: "info",
    warn: "warn",
    error: "error",
};

export function logMessage(logMessage, level = logLevel.info) {
    switch (level) {
        case "debug":
            console.debug(logMessage);
            break;

        case "info":
            console.info(logMessage);
            break;

        case "warn":
            console.warn(logMessage);
            break;

        case "error":
            console.error(logMessage);
            break;

        default:
            throw new Error(`Unknown log level: ${level}`);
    }
}

export async function withTiming(logMessage, fn) {
    console.time(logMessage);
    return fn().finally(() => {
        console.timeEnd(logMessage);
    });
}
