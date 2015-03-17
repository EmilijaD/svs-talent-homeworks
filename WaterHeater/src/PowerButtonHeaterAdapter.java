import heater.Heater;
import power.PowerDevice;

public class PowerButtonHeaterAdapter implements PowerDevice {

	private Heater heater;

	public PowerButtonHeaterAdapter(Heater heater) {

		this.heater = heater;
	}

	@Override
	public void enable() {
		heater.turnOn();

	}

	@Override
	public void disable() {
		heater.turnOff();

	}

}
