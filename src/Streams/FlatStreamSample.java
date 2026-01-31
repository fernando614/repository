package Streams;
import java.util.*;
import java.util.stream.Collectors;
public class FlatStreamSample {

	public static void main(String[] args) {
		//lo que yo entiendo de este que voy a como aplanar los datos o algo así
		List<List<Integer>> list = List.of(
				List.of(1,2,3),
				List.of(4,5,6),
				List.of(7,8,9)
				);
		List<Integer>flattenedList = list
				.stream()
				.flatMap(List::stream)//este no le entendí muy bien es decir como pasar a lambda
				.collect(Collectors.toList());
		System.out.println(flattenedList);
	}

}
