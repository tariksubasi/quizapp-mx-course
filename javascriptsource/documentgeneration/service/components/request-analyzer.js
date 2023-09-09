function analyzeResponse(statistics, response) {
    const headers = response.headers();
    const size =
        "content-length" in headers ? parseInt(headers["content-length"]) : 0;
    const resourceType = response.request().resourceType();

    if (!statistics.hasOwnProperty(resourceType)) {
        statistics[resourceType] = { count: 1, estimatedSize: size };
    } else {
        statistics[resourceType].count++;
        statistics[resourceType].estimatedSize += size;
    }
}

export function createRequestAnalyzer() {
    const statistics = {};

    return {
        getStatistics: () => statistics,
        analyzeResponse: (response) => analyzeResponse(statistics, response),
    };
}
