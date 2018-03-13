package bootcamp.concurrency;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
	
	long delay;
	
	public CallableImpl(long delay) {
		super();
		this.delay = delay;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(delay);
		return Thread.currentThread().getName();
	}

}
