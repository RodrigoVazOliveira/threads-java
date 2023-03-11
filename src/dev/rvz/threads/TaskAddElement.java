package dev.rvz.threads;

final class TaskAddElement implements Runnable {
    private final ListCustom listCustom;
    private final Integer numberThread;

    public TaskAddElement(ListCustom listCustom, Integer numberThread) {
	this.listCustom = listCustom;
	this.numberThread = numberThread;
    }

    @Override
    public void run() {
	for (Integer i = 0; i < 100; i++) {
	    listCustom.add("Thread " + numberThread + " - " + i);
	}
    }

}
