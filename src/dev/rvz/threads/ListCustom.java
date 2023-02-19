package dev.rvz.threads;

final class ListCustom {

	private final String[] elements = new String[1000];
	private Integer index = 0;
	private Integer length = 0;

	public synchronized void add(String element) {
		elements[index] = element;
		index++;
		length++;
	}

	public Integer getLength() {
		return length;
	}

	public String getElementByIndex(Integer index) {
		return elements[index];
	}
}
