package Streams;
import java.util.*;
import java.util.stream.Collectors;
public class FilterStreamSample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		List<Integer> newList = list
				.stream()
				//filtra los números que sean divisibles entre 2
				.filter(i -> i % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(newList);
		
		List<Integer> l = List.of(1,1,2,2,3,4,5);
		List<Integer>newL = l.stream()
				//distinc elimina duplicados
				.distinct()
				.collect(Collectors.toList());
		System.out.println(newL);
		
		
	}

}
