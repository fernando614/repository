package lambdas;
import java.util.function.*;
public class BiConsumerSample {
	public static void printList(int[]a,BiConsumer<Integer,Integer> c) {
		for(int i : a) {
			c.accept(i, 1);
		}
	}
	public static void main(String[] args) {
		//es una manera de hacerlo
		BiConsumer<Integer,Integer> consumer = (t,v) -> System.out.println(t + v);
		consumer.accept(10, 10);
		
		//segunda manera sumandole 1 a cada elemento de un arreglo
		int[]a = {1,2,3};
		printList(a,(t,v) -> System.out.print(t+v + " "));

	}

}
