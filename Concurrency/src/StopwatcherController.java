import java.util.Scanner;

public class StopwatcherController {

	public static void processCommand(String command, StopwatcherTask task) {
		if (command.contentEquals("start")) {
			task.start();
		} else if (command.contentEquals("stop")) {
			task.stop();
		} else if (command.contentEquals("pause")) {
			task.pause();
		} else if (command.contentEquals("resume")) {
			task.resume();
		} else {
			System.out.println("Invalid command!");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final StopwatcherTask task = new StopwatcherTask();
		final Thread taskThread = new Thread(task);
		taskThread.start();
		while (scanner.hasNext()) {
			String command = scanner.nextLine();
			processCommand(command, task);
		}
		scanner.close();
	}

}
