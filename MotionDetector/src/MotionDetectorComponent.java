import java.util.ArrayList;
import java.util.Scanner;

public class MotionDetectorComponent {

	public static void main(String[] args) {
		String alarm1 = "alarm1";
		String alarm2 = "alarm2";
        ArrayList<String> alarmi= new ArrayList<String>();
        alarmi.add(alarm1);
        alarmi.add(alarm2);
        Alarm alarm = new Alarm();
		CameraDevice camera = new CameraDevice();
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String image1 = scanner.next();
			String image2 = scanner.next();
			if (camera.detectChanges(image1, image2)) {
				alarm.sendAlarm(alarmi);
			}

		}
		scanner.close();
	}

}
