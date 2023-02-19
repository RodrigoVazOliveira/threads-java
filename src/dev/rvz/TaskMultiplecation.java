package dev.rvz;

import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JTextField;

public final class TaskMultiplecation implements Runnable {

    private final JTextField inputNumberOne;
    private final JTextField inputNumberTwo;
    private final JLabel result;

    public TaskMultiplecation(JTextField inputNumberOne, JTextField inputNumberTwo, JLabel result) {
	super();
	this.inputNumberOne = inputNumberOne;
	this.inputNumberTwo = inputNumberTwo;
	this.result = result;
    }

    @Override
    public void run() {
	final Long valueOne = Long.parseLong(inputNumberOne.getText());
	final Long valueTwo = Long.parseLong(inputNumberTwo.getText());
	BigInteger calculate = new BigInteger("0");

	for (Integer i = 0; i < valueOne; i++) {
	    for (Integer j = 0; j < valueTwo; j++) {
		calculate = calculate.add(new BigInteger("1"));
	    }
	}

	result.setText(calculate.toString());
    }

}
