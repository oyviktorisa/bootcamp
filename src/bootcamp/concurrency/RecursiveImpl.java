package bootcamp.concurrency;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class RecursiveImpl extends RecursiveTask<Integer>{

	int[] data;
	int startIndex;
	int endIndex;
	
	public RecursiveImpl(int[] data, int startIndex, int endIndex) {
		this.data = data;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	
	@Override
	protected Integer compute() {
		int range = endIndex - startIndex;
		if(range<=10) {
			return IntStream.of(data).sum();
		} else {
			int middleIndex = (endIndex-startIndex)/2;
			RecursiveImpl left = new RecursiveImpl(Arrays.copyOfRange(data, startIndex, middleIndex), 0, middleIndex);
			RecursiveImpl right = new RecursiveImpl(Arrays.copyOfRange(data, middleIndex+1, endIndex), 0, endIndex-middleIndex);
			left.fork();
			int rightSum = right.compute();
			int leftSum = left.join();
			
			return rightSum + leftSum;
		}
	}

}
