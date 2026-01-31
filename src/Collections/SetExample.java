package Collections;
import java.util.*;
public class SetExample {
	public static void main(String args[]) {
		//creo mi set no permite duplicados
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		//imprime false porque ya ha sido agregado ese elemento
		System.out.println(set.add(10));//output false
		
		set.forEach((s) -> System.out.print(s + " "));
	}
}