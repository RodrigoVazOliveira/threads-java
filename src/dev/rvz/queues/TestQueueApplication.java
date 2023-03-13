package dev.rvz.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestQueueApplication {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> blockingQueueString = new ArrayBlockingQueue<>(3);
		blockingQueueString.put("C1");
		blockingQueueString.put("C2");
		blockingQueueString.put("C3");

		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.take());

		blockingQueueString.put("C4");
		blockingQueueString.put("C5");

		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.size());
	}

}
