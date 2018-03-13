package bootcamp.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentApp {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Callable<String>> callableList = Arrays.asList(
		new CallableImpl(4),
		new CallableImpl(3),
		new CallableImpl(2));
		
		try {
			executor.invokeAll(callableList)
			.stream()
			.map(future -> {
			    try {
			        return future.get();
			    }
			    catch (Exception e) {
			        throw new IllegalStateException(e);
			    }
			})
			.forEach(System.out::println);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(executor.invokeAny(callableList));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}

}
	
}
