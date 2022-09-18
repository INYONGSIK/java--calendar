package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt {

	public static int parseDay(String week) {
		if (week.equals("일"))
			return 0;
		else if (week.equals("월"))
			return 1;
		else if (week.equals("화"))
			return 2;
		else if (week.equals("수"))
			return 3;
		else if (week.equals("목"))
			return 4;
		else if (week.equals("금"))
			return 5;
		else if (week.equals("토"))
			return 6;
		return 0;

	}



	public static void runPrompt() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("연도를 입력해주세요.");
			int year = Integer.parseInt(br.readLine());
			System.out.println("달을 입력해주세요.(-1을 입력하면 프로그램이 종료됩니다)");
			int month = Integer.parseInt(br.readLine()); // 달을 입력받음
			
			if (month == -1) {
				break;
			}
			if (month > 13) {
				continue;
			}
			Calendar.printCalendar(year, month);
		}
		System.out.println("프로그램이 종료 되었습니다.");

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		runPrompt();
	}

}
