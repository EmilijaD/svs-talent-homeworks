package core;



public class PowerButton {
	private int value;
	private PowerDevice device;

	public PowerButton(int value, PowerDevice device) {

		this.value = value;
		this.device = device;
	}

	public void check(int value1) {
		if (value1 < value) {
			device.enable();
		} else {
			device.disable();
		}
	}
}
