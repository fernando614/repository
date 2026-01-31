package Switch;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("enter the day of the week: ");
		String day = keyboard.next();
		
		String getDay = "";
		
		//new way to create a switch statement
		getDay = switch(day.toLowerCase())
		{
		case "monday","sunday": yield "10:00 am";
		default: yield "8:00 am";
		};
		System.out.println(getDay);

	}

}
