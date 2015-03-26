package acme.thermoregulator.components;

import java.util.concurrent.TimeUnit;

import com.acme.interfaces.AcmePoweredDevice;
import com.acme.interfaces.AcmeThermoregulator;
import com.acme.vento.adapters.AcmeVentoThermometarAdapter;

public class AcmeStandardThermoregulator implements AcmeThermoregulator {

	private AcmePoweredDevice poweredDevice; // doesn't have to be heater
	private AcmeVentoThermometarAdapter thermometarAdapter;
	private int seconds = 3;
	private Integer temperature = 0;
	private boolean stop = false;

	private Thread thermoregulator = new Thread() {
		@Override
		public void run() {
			while (!stop) {
				try {
					TimeUnit.SECONDS.sleep(seconds);

					Integer thermoTemp = thermometarAdapter.getTemperature();
					System.out.println(thermoTemp);
					if (temperature > thermoTemp) {
						poweredDevice.enable();

					} else if (temperature < thermoTemp) {
						poweredDevice.disable();

					}

				} catch (Exception e) {
				}
			}
		}
	};

	public AcmeStandardThermoregulator(AcmePoweredDevice poweredDevice,
			AcmeVentoThermometarAdapter thermometarAdapter) {

		this.poweredDevice = poweredDevice;
		this.thermometarAdapter = thermometarAdapter;
	}

	@Override
	public void enablePower() {
		thermoregulator.start();

	}

	@Override
	public void disablePower() {

		stop = true;

	}

	@Override
	public void setTemperature(Integer temp) {

		temperature = temp;
	}

}
