package com.acme.vento.adapters;

import com.acme.interfaces.AcmePoweredDevice;
import com.ventoelectrics.waterheater.VentoHeater;


public class AcmeVentoPoweredDeviceAdapter implements AcmePoweredDevice {

	private VentoHeater heater;

	public AcmeVentoPoweredDeviceAdapter(VentoHeater heater) {
		this.heater = heater;
	}

	public void enable() {
		heater.enable();
	}

	public void disable() {
		heater.disable();
	}


}
