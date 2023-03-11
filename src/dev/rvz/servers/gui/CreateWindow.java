package dev.rvz.servers.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public final class CreateWindow {
    private final JFrame window;
    private final PrintStream printStream;
    private final JTextArea jTextArea;

    public CreateWindow(JFrame window, PrintStream printStream, JTextArea jTextArea) {
	this.window = window;
	this.printStream = printStream;
	this.jTextArea = jTextArea;
    }

    public void execute() {
	final Dimension dimension = new Dimension(600, 400);
	window.setMinimumSize(dimension);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	final CreateButton createButton = new CreateButton(window, printStream);
	createButton.execute();

	final CreateInputTextArea createInputTextArea = new CreateInputTextArea(window, jTextArea);
	createInputTextArea.execute();

	final GridLayout gridLayoutFullWindow = new GridLayout(2, 1);
	window.setLayout(gridLayoutFullWindow);
	window.pack();
	window.setVisible(true);
    }
}
