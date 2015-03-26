package com.ventoelectrics.waterheater;

import acme.thermoregulator.components.AcmeEfficientThermoregulator;

import com.acme.interfaces.AcmePoweredDevice;
import com.acme.interfaces.AcmeThermoregulator;
import com.acme.vento.adapters.AcmeVentoPoweredDeviceAdapter;
import com.acme.vento.adapters.AcmeVentoThermometarAdapter;
import com.acme.vento.adapters.AcmeVentoThermoregulatorAdapter;

public class EfficientVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final AcmePoweredDevice apd = new AcmeVentoPoweredDeviceAdapter(ventoHeater);
		final AcmeVentoThermometarAdapter avta = new AcmeVentoThermometarAdapter(ventoThermometer);
		final AcmeThermoregulator at = new  AcmeEfficientThermoregulator(apd, avta);
		
		final VentoThermoregulator ventoThermoregulator = new AcmeVentoThermoregulatorAdapter(at);

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
