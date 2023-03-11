package dev.rvz.party;

final class GuestOne implements Runnable {

	private final Bathroom bathroom;

	public GuestOne(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public void run() {
		this.bathroom.makeNumberOne();
	}

}
