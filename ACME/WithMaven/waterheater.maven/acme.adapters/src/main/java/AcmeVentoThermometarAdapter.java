
public class AcmeVentoThermometarAdapter {

	private VentoThermometer thermometer;

	public AcmeVentoThermometarAdapter(VentoThermometer thermometer) {
		this.thermometer = thermometer;
	}

	public Integer getTemperature() {
		return thermometer.getTemperature();
	}

}
