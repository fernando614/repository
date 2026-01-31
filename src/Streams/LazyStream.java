package Streams;
import java.util.stream.Stream;
public class LazyStream {

	public static void main(String[] args) {
		Stream<String>stream = Stream.of("fer","iker","alvaro","edgar");
		stream
		.map(s -> s.length())
		.filter(s -> s > 3)
		.forEach(System.out::print);

	}

}
