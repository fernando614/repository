package Streams;
import java.util.*;
public class ReduceStreamSample {

	public static void main(String[] args) {
		List<Integer> list = List.of(1,2,3,4,5);
		//primera forma es con optional
		Optional<Integer> sum = list
				.stream()
				.reduce((x,y) -> x+y);
		System.out.println(sum.get());
		//segunda forma con un Integer
		Integer count =  list
				.stream()
				//se le agrega un 0 en caso de que la lista este vacía
				.reduce(0,(x,y) -> x+y);
		System.out.println(count);
		
	}

}
