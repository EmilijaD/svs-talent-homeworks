public class AcmeVentoThermoregulatorAdapter implements VentoThermoregulator {

	private AcmeThermoregulator thermoregulator;

	public AcmeVentoThermoregulatorAdapter(AcmeThermoregulator thermoregulator) {

		this.thermoregulator = thermoregulator;
	}

	public void enablePower() {
		thermoregulator.enablePower();

	}

	public void disablePower() {
		thermoregulator.disablePower();

	}

	public void setTemperature(Integer temperature) {
		thermoregulator.setTemperature(temperature);

	}

}
