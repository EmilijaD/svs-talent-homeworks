import interfaces.ImageCapturingDevice;

public class CameraDevice implements ImageCapturingDevice {

	@Override
	public boolean detectChanges(String image1, String image2) {
		if (image1.contains(image2)) {
			return false;
		}
		return true;
	}

}
