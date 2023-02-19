package dev.rvz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ApplicationWindow {

    private final JTextField inputNumberOne;
    private final JTextField inputNumberTwo;
    private final JLabel result;
    private final JButton action;
    private final JFrame window;

    public ApplicationWindow(JTextField inputNumberOne, JTextField inputNumberTwo, JLabel result, JButton action,
	    JFrame window) {
	this.inputNumberOne = inputNumberOne;
	this.inputNumberTwo = inputNumberTwo;
	this.result = result;
	this.action = action;
	this.window = window;
    }

    public void run() {
	JPanel painel = new JPanel();
	painel.add(inputNumberOne);
	painel.add(new JLabel("x"));
	painel.add(inputNumberTwo);
	painel.add(action);
	painel.add(result);

	window.add(painel);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.pack();
	window.setVisible(true);
    }
}
