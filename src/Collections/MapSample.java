package Collections;
import java.util.*;

public class MapSample {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<>();
		//Map<String,String>map = new TreeMap<>(); otra manera de hacerlo
		
		map.put("Ferando", "hamburguesas");
		map.put("Alvaro","enchiladas");
		
		for(String key : map.keySet()) {
			//imprime los valores de las llaves
			//System.out.println(map.get(key));
			System.out.println(key);
		}
		
		map.putIfAbsent("Iker", "spagheti");
		System.out.println(map);
		
		
	}

}
