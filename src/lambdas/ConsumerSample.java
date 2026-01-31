package lambdas;
import java.util.function.*;
public class ConsumerSample {
	public static void printList(int[]a,Consumer<Integer>c) {
		for(int i : a) {
			c.accept(i);
		}
	}
	public static void main(String[] args) {
		int[]a = {1,2,3,4,5,6,7,8};
		Consumer<Integer> consumer = c -> System.out.print(c + " ");
		printList(a,consumer);

	}

}
