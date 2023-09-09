package documentgeneration.implementation;

import java.util.concurrent.TimeUnit;

import com.mendix.logging.ILogNode;

import documentgeneration.proxies.constants.Constants;

public class WaitWithBackoffStrategy implements IWaitStrategy {
	private long startTime;
	private long maxDuration;
	
	public WaitWithBackoffStrategy() {
		startTime = System.currentTimeMillis();
		maxDuration = TimeUnit.MILLISECONDS.convert(Constants.getSyncTimeoutInSeconds(), TimeUnit.SECONDS);
	}
	
	@Override
	public boolean canContinue() {
		return System.currentTimeMillis() - startTime < maxDuration;
	}

	@Override
	public void wait(int attempt) throws InterruptedException {
		int index = attempt < waitSequence.length ? attempt : waitSequence.length - 1;
        int waitTime = waitSequence[index] * 1000;

        logging.trace("Wait using backoff: " + waitTime + "ms");
        Thread.sleep(waitTime);
	}
	
    private static final int[] waitSequence = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 5, 5, 5, 8};
    private static final ILogNode logging = Logging.logNode;

}
