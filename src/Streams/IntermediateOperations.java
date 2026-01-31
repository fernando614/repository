package Streams;
import java.util.stream.Stream;
import java.util.stream.Stream.*;
public class IntermediateOperations {

	public static void main(String[] args) {
		Stream<String> words = Stream.of("c","b","a");
		words
		.sorted()
		.limit(1);

	}

}
