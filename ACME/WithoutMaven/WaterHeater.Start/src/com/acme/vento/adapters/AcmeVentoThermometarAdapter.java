package com.acme.vento.adapters;

import com.ventoelectrics.waterheater.VentoThermometer;

public class AcmeVentoThermometarAdapter {

	private VentoThermometer thermometer;

	public AcmeVentoThermometarAdapter(VentoThermometer thermometer) {
		this.thermometer = thermometer;
	}

	public Integer getTemperature() {
		return thermometer.getTemperature();
	}

}
