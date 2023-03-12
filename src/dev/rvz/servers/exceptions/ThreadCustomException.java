package dev.rvz.servers.exceptions;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadCustomException implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("thread " + t.threadId() + " error: " + e.getMessage());
	}

}
