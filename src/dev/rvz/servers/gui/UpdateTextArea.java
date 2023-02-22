package dev.rvz.servers.gui;

import javax.swing.JTextArea;

public final class UpdateTextArea {
	private final JTextArea jTextArea;

	public UpdateTextArea(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}

	public void update(final String text) {
		final String newLine = System.getProperty("line.separetor");
		jTextArea.append(text + newLine);
	}
}
