package dev.rvz.servers.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public final class ActionButtonDefault implements ActionListener {

	private final String text;
	private final PrintStream printStream;

	public ActionButtonDefault(String text, PrintStream printStream) {
		this.text = text;
		this.printStream = printStream;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		printStream.println(text);
	}

}
