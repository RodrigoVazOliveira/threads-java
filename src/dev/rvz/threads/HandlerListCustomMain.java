package dev.rvz.threads;

import java.util.List;
import java.util.Vector;

public final class HandlerListCustomMain {

	public static void main(String[] args) throws InterruptedException {
		final List<String> strings = new Vector<>();
		for (Integer i = 0; i < 10; i++) {
			final Thread thread = new Thread(new TaskAddElement(strings, i));
			thread.start();
		}

		Thread.sleep(2000);

		final int sizeStrings = strings.size();
		for (Integer i = 0; i < sizeStrings; i++) {
			System.out.println(strings.get(i));
		}
	}

}