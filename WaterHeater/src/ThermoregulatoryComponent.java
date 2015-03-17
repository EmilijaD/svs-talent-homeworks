import heater.Heater;

import java.util.Scanner;

import power.PowerButton;
import power.PowerDevice;

public class ThermoregulatoryComponent {

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
