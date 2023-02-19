package dev.rvz.party;

public final class GuestTwo implements Runnable {

	private final Bathroom bathroom;

	public GuestTwo(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public void run() {
		this.bathroom.makeNumberTwo();
	}

}
