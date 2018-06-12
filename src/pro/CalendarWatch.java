package pro;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 一个简单的日历
 * @author kangpan
 *
 */
public class CalendarWatch {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		int today = date.getDayOfMonth();	
		int year = date.getYear();
		int mon = month;
		while(mon <= 12) {
			date = LocalDate.of(year, mon, today);
			date = date.minusDays(today - 1);
			DayOfWeek weekday = date.getDayOfWeek();
			int value = weekday.getValue();
			//7 1 2 3 4 5 6 
			if(mon < 10) {
				System.out.println("-------------" + "0" + mon + "------------");
			}else {
				System.out.println("-------------" + mon + "------------");
			}

			System.out.println("Sun Mon Tue Wed Thu Fri Sat");
			System.out.println("---------------------------");
			if(7 == value) {
				System.out.print("");
			}else {
				for(int i = 0; i < value; i++) {
					System.out.print("    ");
				}
			}
			while(date.getMonthValue() == mon) {
				System.out.printf("%3d", date.getDayOfMonth());
				if(date.getDayOfMonth() == today && mon == month) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
				date = date.plusDays(1);
				if(7 == date.getDayOfWeek().getValue()) {
					System.out.println();
				}			
			}
			if(7 != date.getDayOfWeek().getValue()) {
				System.out.println();
			}
			System.out.println();
			mon ++;
		}
	} 		
}
