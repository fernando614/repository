package Collections;
import java.util.*;
public class QueExample {
	public static void main(String args[]) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		//agrego mis elementos a mi queue
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println("El elemento al inicio de la cola es: " + queue.peek());
		//itero sobre mi cola
		while(!queue.isEmpty()) {
			//extraigo mis elementos de la lista hasta que este vacía
			int i = queue.poll();
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(queue.peek());//null
		System.out.println(queue.isEmpty());
	}
}
