package documentgeneration.implementation;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.systemwideinterfaces.core.IMendixObject;

interface RequestInfo {
    boolean canContinue();
}

public class RequestManager {
    private static final ConcurrentMap<Long, Thread> pendingWaits = new ConcurrentHashMap<>();

    public static IMendixObject waitForDocumentContent(
            IWaitStrategy waitStrategy,
            String entityType,
            IMendixIdentifier requestIdentifier
    ) {
        pendingWaits.put(requestIdentifier.toLong(), Thread.currentThread());
        try {
            for (int i = 0; waitStrategy.canContinue(); i++) {
                Optional<IMendixObject> mendixObject = loadFileDocumentWithContent(entityType, requestIdentifier.toLong());
                if (mendixObject.isPresent()) {
                    logging.trace("Document content is available");
                    return mendixObject.get();
                }

                logging.trace("Document content is not yet available, continue polling");
                waitStrategy.wait(i);
            }
            logging.trace("Document content has not appeared, stopping polling");
        } catch (InterruptedException e) {
            Optional<IMendixObject> mendixObject = loadFileDocumentWithContent(entityType, requestIdentifier.toLong());
            if (mendixObject.isPresent()) {
                logging.trace("Interrupted polling, document content is available");
                return mendixObject.get();
            }
        } finally {
            pendingWaits.remove(requestIdentifier.toLong());
        }
        throw new RuntimeException("Timeout while waiting for document content; no content was received");
    }

    public static void completePendingRequest(IMendixIdentifier id) {
        Thread waitingThread = pendingWaits.get(id.toLong());
        if (waitingThread != null) {
            waitingThread.interrupt();
        }
    }
    
    private static Optional<IMendixObject> loadFileDocumentWithContent(String entityName, long requestIdentifier) {
        String query = String.format("//%s[DocumentGeneration.DocumentRequest_FileDocument = $id][HasContents]", entityName);
        return Core.createXPathQuery(query)
                .setVariable("id", requestIdentifier)
                .execute(Core.createSystemContext())
                .stream()
                .findAny();
    }
    
    private static final ILogNode logging = Logging.logNode;
}