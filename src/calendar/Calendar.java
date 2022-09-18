package calendar;

public class Calendar {
	private final static int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 1~12월 달의 일수
	private final static int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 윤년

	public static int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else
			return MAX_DAYS[month];
	}

	// 운년구하기
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else
			return false;

	}

	// 년월일의 첫번째 요일구하기
	private static int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970년 1월 1일은 목요일임

		int count = 0;
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		for (int i = 1; i <month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		count += day;
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday-1;
	}

	public static void printCalendar(int year, int month) {
		System.out.println("   " + year + "년" + "   " + month + "월");
		System.out.println("    일  월  화  수  목  금  토");
		System.out.println("  ==================");

		int weekday = getWeekDay(year, month, 1);

		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = Calendar.getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = count < 7 ? count : 0;
		;

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		// print from second line to last
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();

	}
}
