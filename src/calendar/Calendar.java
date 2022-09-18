package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calendar {
	private final static int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 1~12월 달의 일수

	public static int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	// 월을 입력하면 해당월의 달력을 출력
	// 일단 1일은 일요일로 설정

	public static void printCalendar(int year, int month) {
		System.out.println("   " + year + "년" + "   " + month + "월");
		System.out.println("    일  월  화  수  목  금  토");
		System.out.println("  ==================");
		int maxDay = Calendar.getMaxDaysOfMonth(month);
		for (int i = 1; i < maxDay; i++) {
			System.out.printf("%3d",i);
			if(i%7==0) {
				System.out.println();
			}
		}
		
	}

}
