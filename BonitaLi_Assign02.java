/*
BonitaLi_Assign02.java is written by B. Li on Oct 3, 2021.
It is a code meant for displaying inputted date and the weekday. 
*/
import java.util.Scanner; //package import for Scanner class
public class BonitaLi_Assign02{
	public static void main (String[] args){
	Scanner inData = new Scanner(System.in); //Scanner class object declaration
	int day, month, year, monthCode, yearCode, centuryCode, process;
	boolean leapYear, userInputCorrect = true;
	String weekDay;
	System.out.println("Input a date by entering the day number (1 to 31), month (1 to 12), and year (1970 to 2100) separated by a space."); //user input for day, month, year
	day = inData.nextInt();
	month = inData.nextInt();
	year = inData.nextInt();
	if (day == 0 || day > 31) { //checking user input
		userInputCorrect = false;
		System.out.println("Please choose a day between 1 to 31 as " + day + " is outside of the range."); 
	}
	if (month < 0 || month > 12) {
		userInputCorrect = false;
		System.out.println("Please choose a month between 1 to 12 as " + month + " is outside of the range."); 
	}
	if (year < 1970 || year > 2100) {
		userInputCorrect = false;
		System.out.println("Please choose a year between 1970 to 2100 as " + year + " is outside of the range."); 
	}
	if (month == 4 && day > 30 || month == 6 && day > 30 || month == 9 && day > 30 || month == 11 && day > 30) { //if year is a leap year
		userInputCorrect = false;
		System.out.println("Please choose a day between 1 to 30 as the inputted month doesn't have a " + day + "."); 
	}
	if (year % 4 == 0 && year % 100 != 0 || year %400 == 0) { //if year is leap year
		leapYear = true;
	}
	else {
		leapYear = false;
	}
	if (leapYear == true && month == 2 && day > 29) { //if leap year and month is february
		userInputCorrect = false;
		System.out.println(day + " is outside the valid range as February on a leap year has 29 days.");	
	}
	if (leapYear == false && month == 2 && day > 28)  { //if non-leap year and month is february
		userInputCorrect = false;
		System.out.println(day + " is outside the valid range as February on a non-leap year has 28 days.");	
	}
	centuryCode = (year / 100) % 4; //century code calculation
	if (centuryCode == 0){
		centuryCode = 6;
	} else if (centuryCode == 1) {
		centuryCode = 4;
	} else if (centuryCode == 2) {
		centuryCode = 2;
	} else {
		centuryCode = 0;
	}
	if (month == 1 || month == 10) { //month code for each month
		monthCode = 0;
	} else if (month == 2 || month == 3 || month == 11) {
		monthCode = 3;
	} else if (month == 4 || month == 7) {
		monthCode = 6;
	} else if (month == 5) {
		monthCode = 1;
	} else if (month == 6) {
		 monthCode = 4;
	} else if (month == 8) {
		monthCode = 2;
	} else {
		monthCode = 5;
	}
	if (leapYear == true) { //if year is leap year and month is january or february subtract 1
		if (month == 1 || month == 2) {
			monthCode = monthCode - 1 ;
		}
	}
	yearCode = year % 100; //year code calculation
	yearCode = (yearCode + (yearCode / 4)) % 7;
	process = (centuryCode + yearCode + monthCode + day) % 7; //calculation to get number 0-6 for weekday
	switch (process) {
		case 0:
			weekDay = "Sunday";
			break;
		case 1:
			weekDay = "Monday";
			break;
		case 2:
			weekDay = "Tuesday";
			break;
		case 3:
			weekDay = "Wedsday";
			break;
		case 4:
			weekDay = "Thursday";
			break;
		case 5:
			weekDay = "Friday";
			break;
		default:
			weekDay = "Saturday";
	}
	if (userInputCorrect == true) { //output day, month, year, and weekday
	System.out.printf("%-13s%4.1s%7s\n", "Date (yyyy/mm/dd)", ":", "Day");
	System.out.printf("%1s\n","-------------------------------------------");
	System.out.printf("%-4d/%-1d/%-2d%30s\n", year, month, day, weekDay);
	}
	} //ends main method
	} //class ends
