package dev.rvz.party;

final class Bathroom implements MakeBathRoom {
	private Boolean isDirty = true;

	@Override
	public void makeNumberOne() {
		final String nameThread = Thread.currentThread().getName();
		System.out.println(nameThread + " Batendo na porta");

		synchronized (this) {

			System.out.println(nameThread + " Entrando no banheiro");
			while (isDirty) {
				this.waitOutSide(nameThread);
			}

			System.out.println(nameThread + " Fazendo coisa rápida");

			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.isDirty = true;
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
			while (isDirty) {
				this.waitOutSide(nameThread);
			}

			System.out.println(nameThread + " Fazendo coisa demorada");

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.isDirty = true;
			System.out.println(nameThread + " Dando descarga");
			System.out.println(nameThread + " Lavando a mão");
			System.out.println(nameThread + " Saindo do banheiro");
		}
	}

	public void waitOutSide(String name) {
		System.out.println(name + ", eca, banheiro está sujo!");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clean() {
		final String name = Thread.currentThread().getName();
		System.out.println(name + " batendo na porta");

		synchronized (this) {
			System.out.println(name + " Entrando no banheiro");
			if (!this.isDirty) {
				System.out.println(name + ", não está sujo, vou sair.");
				return;
			}
			System.out.println(name + " limpando o banheiro.");
			this.isDirty = false;
			try {
				Thread.sleep(13000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.notifyAll();
			System.out.println(name + " saindo do banheiro.");
		}
	}
}
