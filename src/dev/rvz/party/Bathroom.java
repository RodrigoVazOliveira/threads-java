package dev.rvz.party;

final class Bathroom implements MakeBathRoom {

	@Override
	public void makeNumberOne() {
		final String nameThread = Thread.currentThread().getName();
		System.out.println(nameThread + " Batendo na porta");

		synchronized (this) {

			System.out.println(nameThread + " Entrando no banheiro");
			System.out.println(nameThread + " Fazendo coisa rápida");

			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nameThread + " Dando descarga");
			System.out.println(nameThread + " Lavando a mão");
			System.out.println(nameThread + " Saindo do banheiro");
		}
	}

	@Override
	public void makeNumberTwo() {
		final String nameThread = Thread.currentThread().getName();
		System.out.println(nameThread + " Batendo na porta");
		synchronized (this) {
			System.out.println(nameThread + " Entrando no banheiro");
			System.out.println(nameThread + " Fazendo coisa demorada");

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nameThread + " Dando descarga");
			System.out.println(nameThread + " Lavando a mão");
			System.out.println(nameThread + " Saindo do banheiro");
		}
	}

}
