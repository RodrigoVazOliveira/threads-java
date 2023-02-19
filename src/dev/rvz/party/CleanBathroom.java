package dev.rvz.party;

final class CleanBathroom implements Runnable {

	private final Bathroom bathroom;

	public CleanBathroom(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public void run() {
		this.bathroom.clean();
	}

}
