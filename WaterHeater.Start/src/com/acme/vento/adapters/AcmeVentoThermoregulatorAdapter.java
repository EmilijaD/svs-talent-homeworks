package com.acme.vento.adapters;

import com.acme.interfaces.AcmeThermoregulator;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class AcmeVentoThermoregulatorAdapter implements VentoThermoregulator {

	private AcmeThermoregulator thermoregulator;

	public AcmeVentoThermoregulatorAdapter(AcmeThermoregulator thermoregulator) {

		this.thermoregulator = thermoregulator;
	}

	@Override
	public void enablePower() {
		thermoregulator.enablePower();

	}

	@Override
	public void disablePower() {
		thermoregulator.disablePower();

	}

	@Override
	public void setTemperature(Integer temperature) {
		thermoregulator.setTemperature(temperature);

	}

}
