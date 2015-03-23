package termoregulator;

import java.util.Scanner;

import core.PowerButton;
import core.PowerDevice;
import adapter.Heater;
import adapter.PowerButtonHeaterAdapter;



public class TermoregulatoryComponent {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Heater heater = new Heater();
		PowerDevice heaterAdapter = new PowerButtonHeaterAdapter(heater);
		PowerButton heaterButton = new PowerButton(200, heaterAdapter);
		while (scanner.hasNextLine()) {
			int temp = scanner.nextInt();
			heaterButton.check(temp);

		}
		scanner.close();
	}

}
