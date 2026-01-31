package Streams;
import java.util.*;
import java.util.stream.Collectors; 
public class MapStreamSample {

	public static void main(String[] args) {
		List<String>stringNumbers = List.of("1","2","3","4","5");
		List<Integer>integerNumbers = stringNumbers
				.stream()
				//map transforma esos datos a enteros
				.map(s -> Integer.parseInt(s))//map(Integer::parseInt)
				.collect(Collectors.toList());
		System.out.println(integerNumbers);
		
		//en este ejemplo uso doble map
		List<String>list = List.of("1","2","3");
		List<Integer>newList = list
				.stream()
				.map(Integer::parseInt)
				.map(i -> i * 2)
				.collect(Collectors.toList());
		System.out.println(newList);
	}

}
