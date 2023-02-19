package dev.rvz.calculate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateWindow {

    private final JFrame window;

    public CreateWindow(JFrame window) {
	super();
	this.window = window;
    }

    public ApplicationWindow createWindow() {
	JTextField inputNumberOne = new JTextField(10);
	JTextField inputNumberTwo = new JTextField(10);
	JButton button = new JButton(" = ");
	JLabel result = new JLabel("              ?             ");

	ActionButton actionButton = new ActionButton(inputNumberOne, inputNumberTwo, result);
	button.addActionListener(actionButton);

	ApplicationWindow applicationWindow = new ApplicationWindow(inputNumberOne, inputNumberTwo, result, button,
		window);

	return applicationWindow;
    }
}
