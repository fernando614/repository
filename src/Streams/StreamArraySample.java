package Streams;
import java.util.*;
import java.util.stream.Stream;
public class StreamArraySample {
	public static void main(String args[]) {
		//primera manera de crear un stream
		List<String> names = Arrays.asList("Fer","Iker");
		Stream<String>stream = names.stream();
		System.out.println(stream);
		//segunda manera de crear un stream
		String[]words = {"a","b","c"};
		Stream<String>stream1 = Stream.of(words);
		System.out.println(stream1.count());
		//tercera manera de crear streams pero con un detalle
		//si hago un arreglo int[] no lo toma como primitivos si no como un objeto int[] es un objeto
		//no toma la versión of con var-args, por lo tanto hay que usar Integer
		Integer[]numbers = {1,2,3,4,5};
		Stream<Integer>stream2 = Stream.of(numbers);
		System.out.println(stream2.count());
		
	}
}
