package dev.rvz.threads;

public final class HandlerListCustomMain {

    public static void main(String[] args) throws InterruptedException {
	final ListCustom listCustom = new ListCustom();
	for (Integer i = 0; i < 10; i++) {
	    final Thread thread = new Thread(new TaskAddElement(listCustom, i));
	    thread.start();
	}

	Thread.sleep(2000);

	final Thread thread = new Thread(new TaskPrintList(listCustom));
	thread.start();
    }
}
