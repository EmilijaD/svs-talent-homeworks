
public class EfficientVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final AcmePoweredDevice apd = new AcmeVentoPoweredDeviceAdapter(
				ventoHeater);
		final AcmeVentoThermometarAdapter avta = new AcmeVentoThermometarAdapter(
				ventoThermometer);
		final AcmeThermoregulator at = new AcmeEfficientThermoregulator(apd,
				avta);

		final VentoThermoregulator ventoThermoregulator = new AcmeVentoThermoregulatorAdapter(
				at);

		// ACME
		// efficient
		// thermoregulator
		// instance.

		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
