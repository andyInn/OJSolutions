package jiuDuOj_Answers;

import java.util.Scanner;

public class Main_1553 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputTime1 = "";
		String[] reStrings = null;

		float clockHour = 0f;
		float clockHourTemp = 0f;
		float clockMinute = 0f;
		float re = 0f;
		String result = "";

		while (sc.hasNext()) {
			inputTime1 = sc.nextLine();
			reStrings = inputTime1.split(":");
			clockHour = 30f * Integer.parseInt(reStrings[0]);
			clockHourTemp = 0.5f * Integer.parseInt(reStrings[1]);
			clockMinute = 6f * Integer.parseInt(reStrings[1]);
			clockHour += clockHourTemp;
			clockHour = clockHour > 360f ? clockHour - 360 : clockHour;
			clockMinute = clockMinute > 360f ? clockMinute - 360 : clockMinute;
			re = Math.abs(clockHour - clockMinute);
			re = re > 180f ? 360f - re : re;
			result = String.format("%.2f", re);

			System.out.println(result);
		}
	}
}