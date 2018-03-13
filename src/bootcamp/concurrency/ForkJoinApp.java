package bootcamp.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class ForkJoinApp {
	private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
	private static int i = 0;
	
	private static Integer getData() {
		return i++;
	}
	
	public static void main(String[] args) {
		int size = 1000;
		
		int[] data = Stream.generate(() -> getData()).limit(size).mapToInt(Integer::intValue).toArray();
		
		int result = FORK_JOIN_POOL.invoke(new RecursiveImpl(data,0,size-1));
		
		System.out.println(result);
		
		
	}
}
