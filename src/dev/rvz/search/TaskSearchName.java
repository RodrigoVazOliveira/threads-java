package dev.rvz.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class TaskSearchName implements Runnable {

	private final String nameFile;
	private final String name;

	public TaskSearchName(String nameFile, String name) {
		this.nameFile = nameFile;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(nameFile));
			Integer numberLine = 1;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.toLowerCase().contains(name.toLowerCase())) {
					System.out.println(nameFile + " - " + numberLine + " - " + line);
				}
				numberLine++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
