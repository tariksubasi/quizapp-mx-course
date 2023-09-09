package documentgeneration.implementation;

public interface IWaitStrategy {
	boolean canContinue();
	void wait(int attempt) throws InterruptedException;
}
