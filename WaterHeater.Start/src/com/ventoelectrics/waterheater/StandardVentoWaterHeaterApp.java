package com.ventoelectrics.waterheater;

import acme.thermoregulator.components.AcmeStandardThermoregulator;
import com.acme.interfaces.AcmePoweredDevice;
import com.acme.vento.adapters.AcmeVentoPoweredDeviceAdapter;
import com.acme.vento.adapters.AcmeVentoThermometarAdapter;
import com.acme.vento.adapters.AcmeVentoThermoregulatorAdapter;

public class StandardVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final AcmeVentoThermometarAdapter avta = new AcmeVentoThermometarAdapter(
				ventoThermometer);
		final AcmePoweredDevice apd = new AcmeVentoPoweredDeviceAdapter(
				ventoHeater);

		final VentoThermoregulator ventoThermoregulator = new AcmeVentoThermoregulatorAdapter(
				new AcmeStandardThermoregulator(apd, avta));

		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
