package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calendar {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 숫자를 입력받아 해당하는 달의 일수를 출력하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("달을 입력해주세요.");
		
		int month = Integer.parseInt(br.readLine()); //달을 입력받음
		
		int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 1~12월 달의 일수
		System.out.println(month+"월달은"+maxDays[month-1]+"까지 있습니다.");

	}

}
