import java.util.ArrayList;

import interfaces.AlarmChannel;

public class Alarm implements AlarmChannel {

	@Override
	public void sendAlarm(ArrayList<String> alarmi) {
		System.out
				.println("Alarm is invoked because two different pictures were detected ");
		for (int i = 0; i < alarmi.size(); i++) {
			System.out.println("Alarm: " + alarmi.get(i));
		}

	}

}
