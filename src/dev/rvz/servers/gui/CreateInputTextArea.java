package dev.rvz.servers.gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class CreateInputTextArea {
	private final JFrame window;
	private final JTextArea jTextArea;

	public CreateInputTextArea(JFrame window, JTextArea jTextArea) {
		this.window = window;
		this.jTextArea = jTextArea;
	}

	public void execute() {
		final JPanel jpanel = new JPanel();
		jpanel.setBorder(BorderFactory.createTitledBorder("Resposta Servidor"));
		final BoxLayout boxLayout = new BoxLayout(jpanel, BoxLayout.X_AXIS);
		jpanel.setLayout(boxLayout);
		final JScrollPane jScrollPane = createTextArea();
		jpanel.add(jScrollPane);
		window.add(jpanel);
	}

	private JScrollPane createTextArea() {
		jTextArea.setLineWrap(true);
		final JScrollPane jScrollPane = new JScrollPane(jTextArea);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		return jScrollPane;
	}
}
