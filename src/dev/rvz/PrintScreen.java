package dev.rvz;

public final class PrintScreen implements Runnable {

    @Override
    public void run() {
	for (Integer i = 0; i < 1000; i++) {
	    System.out.println("Olá");
	}
    }

}
