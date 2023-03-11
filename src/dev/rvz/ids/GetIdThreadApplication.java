package dev.rvz.ids;

public final class GetIdThreadApplication {

    public static void main(String[] args) {
	Runnable printIdsThread = new PrintIdsThread();
	Thread taskGetIds = new Thread(printIdsThread, "Get ids");
	taskGetIds.start();
    }

}
