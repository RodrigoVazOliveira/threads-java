package dev.rvz.calculate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActionButton implements ActionListener {

    private final JTextField inputNumberOne;
    private final JTextField inputNumberTwo;
    private final JLabel result;

    public ActionButton(JTextField inputNumberOne, JTextField inputNumberTwo, JLabel result) {
	super();
	this.inputNumberOne = inputNumberOne;
	this.inputNumberTwo = inputNumberTwo;
	this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	TaskMultiplecation taskMultiplecation = new TaskMultiplecation(inputNumberOne, inputNumberTwo, result);
	Thread threadMultiplication = new Thread(taskMultiplecation, "Thread calculadora");
	threadMultiplication.start();
    }
}