package dev.rvz.threads;

import java.util.List;

final class TaskAddElement implements Runnable {
	private final List<String> strings;
	private final Integer numberThread;

	public TaskAddElement(List<String> strings, Integer numberThread) {
		this.strings = strings;
		this.numberThread = numberThread;
	}

	@Override
	public void run() {
		for (Integer i = 0; i < 100; i++) {
			strings.add("Thread " + numberThread + " - " + i);
		}
	}

}
