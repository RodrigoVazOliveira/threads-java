package dev.rvz.party;

final class CleanBathroom implements Runnable {

	private final Bathroom bathroom;

	public CleanBathroom(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public void run() {
		while (true) {
			this.bathroom.clean();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
