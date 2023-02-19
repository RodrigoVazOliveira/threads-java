package dev.rvz.ids;

/**
 * 
 * Imprimi os ids das threads
 * 
 * @author Rodrigo Vaz
 *
 */
public final class PrintIdsThread implements Runnable {

	@Override
	public void run() {
		for (Integer i = 0; i < 1000; i++) {
			Thread threadCurrent = Thread.currentThread();
			final Long id = threadCurrent.threadId();
			System.out.println(id + " - " + i);
		}

	}

}
