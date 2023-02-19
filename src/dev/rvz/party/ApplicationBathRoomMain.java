package dev.rvz.party;

class ApplicationBathRoomMain {

	public static void main(String[] args) {
		Bathroom bathroom = new Bathroom();
		Thread taskBathroomOne = new Thread(new GuestOne(bathroom), "João");
		Thread taskBathroomTwo = new Thread(new GuestTwo(bathroom), "Josh");
		Thread taskBathroomThree = new Thread(new GuestOne(bathroom), "Maria");
		Thread taskBathroomFour = new Thread(new GuestTwo(bathroom), "Ana");
		taskBathroomOne.start();
		taskBathroomTwo.start();
		taskBathroomThree.start();
		taskBathroomFour.start();
	}

}
