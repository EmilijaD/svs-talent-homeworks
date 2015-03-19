package numberPrinter;

import java.util.Scanner;

public class NumberPrinter {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		final TaskThatSleeps task = new TaskThatSleeps(number);
		final Thread taskThread = new Thread(task);

		long interuptTime = scanner.nextLong();
		taskThread.start();

		Thread.sleep(interuptTime);
		System.out.println("Interupting the task...");
		taskThread.interrupt();
		scanner.close();
	}

	public static class TaskThatSleeps implements Runnable {
		int number;

		public TaskThatSleeps(int number) {
			super();
			this.number = number;
		}

		@Override
		public void run() {
			int i = 1;
			while (i <= number) {
				System.out.println(String.valueOf(i++));
				if (Thread.interrupted()) {
					System.out.println("I've been interrupted.");
					return;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("I've been interupted while sleeping.");
					return;
				}
			
			}
		}

	}

}
