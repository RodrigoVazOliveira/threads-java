package dev.rvz.threads;

final class TaskPrintList implements Runnable {

	private final ListCustom listCustom;

	public TaskPrintList(ListCustom listCustom) {
		this.listCustom = listCustom;
	}

	@Override
	public void run() {
		synchronized (listCustom) {
			if (!listCustom.isFull()) { // verifica se a lista não está cheia
				try {
					System.out.println("Esperando, aguardando notificação");
					listCustom.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			final Integer length = listCustom.getLength();
			for (Integer i = 0; i < length; i++) {
				System.out.println(i + " - " + listCustom.getElementByIndex(i));
			}
		}
	}

}
