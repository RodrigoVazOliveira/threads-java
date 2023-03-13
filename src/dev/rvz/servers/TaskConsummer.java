package dev.rvz.servers;

import java.util.concurrent.BlockingQueue;

public final class TaskConsummer implements Runnable {

	private final BlockingQueue<String> queueCommand;

	public TaskConsummer(BlockingQueue<String> queueCommand) {
		this.queueCommand = queueCommand;
	}

	@Override
	public void run() {
		System.out.println("Consumindo comando C3");
		try {
			String command = null;
			while ((command = queueCommand.take()) != null) {
				Thread.sleep(5000);
				System.out.println("Comando " + command + " Thread " + Thread.currentThread().threadId());

			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
