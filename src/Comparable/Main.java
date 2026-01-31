package Comparable;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Duck duck = new Duck(1);
		Duck duck1 = new Duck(1);
		
		System.out.println(duck.equals(duck1));
		
		List<Duck>ducks = new ArrayList<>();
		ducks.add(new Duck("fred"));
		ducks.add(new Duck("bob"));
		
		Collections.sort(ducks);//ordeno la lista de objetos
		System.out.println(ducks);
		
		Duck myDuck = new Duck();
		List<String> names = new ArrayList<>();
		names.add("alvaro");
		names.add("edgar");
		names.add("fernando");
		
		myDuck.print(names);
		
		
	}

}
