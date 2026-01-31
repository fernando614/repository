package Streams;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class CollectIntoMapSample {

	public static void main(String[] args) {
		//para esto estoy usando collect() y luego los métodos para los ejemplos
		//usando toMap
		Stream<String> cars = Stream.of("vento","testla","bmw");
		//esto lo que hace es tomar la longitud de cada auto y asignarle ese valor como key
		Map<Integer,String> map = cars
				//primero transforma los autos a su respectiva longitud, y luego devuelve el string auto
				//toMap()recibe dos lambdas
				.collect(Collectors.toMap(s -> s.length(), x -> x));//String::length
		System.out.println(map);
		
		//usando groupingBy()
		Stream<String> names = Stream.of("fer","rod","juan","mario","ale");
		Map<Integer,List<String>> mapNames = names
				//recibe un function que recibe un valor y devuelve otro 
				.collect(Collectors.groupingBy(String::length));
		System.out.println(mapNames);
		
		//en este ejemplo contamos la longitud de los animales y los pasamos a una lista
		//y usamos la función mapping(,,)
		Stream<String> animals = Stream.of("cat","dog","elephant");
		List<Integer> len = animals
				//recibe dos parametros mapping primero lo transforma y luego lo colecta en la lista
				.collect(Collectors.mapping(s -> s.length(),Collectors.toList()));
		System.out.println(len);
		
	}

}
