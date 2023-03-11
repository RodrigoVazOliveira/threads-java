package dev.rvz.calculate;

import javax.swing.JFrame;

public class ApplicationMain {

    public static void main(String[] args) throws InterruptedException {
	JFrame window = new JFrame("Multiplicação demorada");
	CreateWindow createWindow = new CreateWindow(window);
	ApplicationWindow applicationWindow = createWindow.createWindow();

	PrintScreen printScreen = new PrintScreen();
	Thread taskPrint = new Thread(printScreen, "Imprimir na tela");
	taskPrint.start();
	applicationWindow.run();
    }

}