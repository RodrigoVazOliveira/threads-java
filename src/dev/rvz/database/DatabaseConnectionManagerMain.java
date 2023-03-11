package dev.rvz.database;

final class DatabaseConnectionManagerMain {

    public void begin() {
	System.out.println("Começando a transação");
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
