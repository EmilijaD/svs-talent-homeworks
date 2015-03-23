package adapter;

import core.PowerDevice;

public class PowerButtonHeaterAdapter implements PowerDevice {

	private Heater heater;

	public PowerButtonHeaterAdapter(Heater heater) {

		this.heater = heater;
	}

	public void enable() {
		heater.turnOn();

	}

	public void disable() {
		heater.turnOff();

	}

}