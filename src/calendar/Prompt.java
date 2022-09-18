package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Prompt {

	public static void printMenu() {
		System.out.println("+---------------");
		System.out.println("| 1. 일정 등록 ");
		System.out.println("| 2. 일정 검색 ");
		System.out.println("| 3. 달력 보기 ");
		System.out.println("| h. 도움말 q. 종료 ");
		System.out.println("+---------------");

	}

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

	public static void runPrompt() throws NumberFormatException, IOException, ParseException {
		printMenu();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calendar cal = new Calendar();
		while (true) {
			String cmd = br.readLine();
			if (cmd.equals("1"))
				cmdRegister(br, cal);
			else if (cmd.equals("2"))
				cmdSearch(br, cal);
			else if (cmd.equals("3"))
				cmdCal();
			else if (cmd.equals("h"))
				printMenu();
			else if (cmd.equals("q"))
				break;
		}
		System.out.println("thank you Bye~~");
	}

	private static void cmdRegister(BufferedReader br, Calendar c) throws IOException, ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = br.readLine();
		System.out.println("일정을 입력해 주세요");
		String text = br.readLine();
		Calendar.registerPlan(date, text);
	}

	private static void cmdSearch(BufferedReader br, Calendar c) throws IOException {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요(yyyy-MM-dd)");
		String date = br.readLine();
		String plan="";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
			System.err.println("일정 검색중 오류가 발생했습니다.");
		}
		System.out.println(plan);
	}

	private static void cmdCal() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("연도를 입력해주세요.");
		int year = Integer.parseInt(br.readLine());
		System.out.println("달을 입력해주세요.(-1을 입력하면 프로그램이 종료됩니다)");
		int month = Integer.parseInt(br.readLine()); // 달을 입력받음

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		Calendar.printCalendar(year, month);
	}

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		runPrompt();
	}

}
