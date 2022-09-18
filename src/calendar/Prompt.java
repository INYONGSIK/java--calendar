package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt  {
	public static void runPrompt() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("달을 입력해주세요.(-1을 입력하면 프로그램이 종료됩니다)");
			int month = Integer.parseInt(br.readLine()); // 달을 입력받음
			if (month == -1) {
				break;
			}
			if (month > 13) {
				continue;
			}
			Calendar.printCalendar(2022, month);
		}
		System.out.println("프로그램이 종료 되었습니다.");

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		runPrompt();
	}

}
