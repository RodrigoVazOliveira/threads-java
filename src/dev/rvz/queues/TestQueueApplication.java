package dev.rvz.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestQueueApplication {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> blockingQueueString = new ArrayBlockingQueue<>(3);
		blockingQueueString.offer("C1");
		blockingQueueString.offer("C2");
		blockingQueueString.offer("C3");

		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.take());
		System.out.println(blockingQueueString.size());
	}

}
