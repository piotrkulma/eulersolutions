package projecteuler;

enum Month {
	JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
}

enum DayOfWeek {
	MON, TUE, WEN, THU, FRI, SAT, SUN
}

public class Problem19 {	
	public static boolean isLeapYear(int year) {
		boolean leap = false;
		
		if(year % 4 == 0) {
			if(year % 100 != 0) {
				leap = true;
			} else {
				if(year % 400 == 0) {
					leap = true;
				}
			}
		} 
		
		return leap;
	}
	
	public static int days(Month month, int year) {
		if(month == Month.FEB) {			
			if(isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		} else if(month == Month.SEP ||
				month == Month.APR||
				month == Month.JUN||
				month == Month.NOV) {
			return 30;
		} else {
			return 31;
		}
	}
	
	public static void main(String[] args) {
		
		int days;
		int day = 0;
		int sundays = 0;

		Month[] months = Month.values();
		
		for(int year=1900; year<=2000; year++) {
			for(int month=0; month<months.length; month++) {		
				if(day == 1 && year > 1900) {
					sundays ++;
				}
				
				days = days(months[month], year);
				while(day < days) {
					day += 7;					
				}
				
				day = day - days;
			}
		}
		
		System.out.println(sundays);
	}
}
