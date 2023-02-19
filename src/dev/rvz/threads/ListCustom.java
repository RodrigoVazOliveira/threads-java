package dev.rvz.threads;

final class ListCustom {

	private final String[] elements = new String[1000];
	private Integer index = 0;
	private Integer length = 0;

	public synchronized void add(String element) {
		elements[index] = element;
		index++;
		length++;

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (this.index == this.elements.length) {
			System.out.println("A lista está cheia, notificando!");
			this.notify();
		}
	}

	public Integer getLength() {
		return length;
	}

	public String getElementByIndex(Integer index) {
		return elements[index];
	}
}
