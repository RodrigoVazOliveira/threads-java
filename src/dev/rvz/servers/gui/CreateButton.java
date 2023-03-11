package dev.rvz.servers.gui;

import java.awt.GridLayout;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class CreateButton {

    private final JFrame window;
    private final PrintStream printStream;

    public CreateButton(JFrame window, PrintStream printStream) {
	this.window = window;
	this.printStream = printStream;
    }

    public void execute() {
	final JPanel jpanel = new JPanel();
	jpanel.setBorder(BorderFactory.createTitledBorder("Comandos"));
	final GridLayout gridLayout = new GridLayout(0, 4, 20, 20);
	jpanel.setLayout(gridLayout);

	final List<JButton> buttons = new ArrayList<JButton>();
	generate(buttons);
	createButtonTerminator(buttons);

	buttons.forEach(jpanel::add);

	window.add(jpanel);
    }

    private void createButtonTerminator(final List<JButton> buttons) {
	final JButton jbuttonTerminatorServer = new JButton("Terminar o servidor (FIM) ");
	final ActionButtonDefault actionButtonDefault = new ActionButtonDefault("Fim", printStream);
	jbuttonTerminatorServer.addActionListener(actionButtonDefault);
	buttons.add(jbuttonTerminatorServer);
    }

    private void generate(final List<JButton> buttons) {
	for (Integer i = 0; i < 3; i++) {
	    final Integer numberCommand = i + 1;
	    final String command = "C" + numberCommand;
	    final JButton jbutton = new JButton("Enviar " + command);

	    final ActionButtonDefault actionButtonDefault = new ActionButtonDefault(command, printStream);
	    jbutton.addActionListener(actionButtonDefault);
	    buttons.add(jbutton);
	}
    }
}
