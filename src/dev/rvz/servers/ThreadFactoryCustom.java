package dev.rvz.servers;

import java.util.concurrent.ThreadFactory;

import dev.rvz.servers.exceptions.ThreadCustomException;

final class ThreadFactoryCustom implements ThreadFactory {

	@Override
	public Thread newThread(Runnable runnable) {
		final Thread thread = new Thread(runnable);
		thread.setUncaughtExceptionHandler(new ThreadCustomException());

		return thread;
	}

}
