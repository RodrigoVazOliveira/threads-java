package dev.rvz.search;

public class ApplicationSearchNameMain {

    public static void main(String[] args) {
	String name = "da";
	Thread taskSearchAssignatureOne = new Thread(new TaskSearchName("assinaturas1.txt", name),
		"Thread search name");
	Thread taskSearchAssignatureTwo = new Thread(new TaskSearchName("assinaturas2.txt", name),
		"Thread search name");
	Thread taskSearchAuthors = new Thread(new TaskSearchName("autores.txt", name), "Thread search name");

	taskSearchAssignatureOne.start();
	taskSearchAssignatureTwo.start();
	taskSearchAuthors.start();
    }

}
