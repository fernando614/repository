package lambdas;
import java.util.function.*;
public class UnarySample {
	//UnaryOperator
	public static int sum(int[]a,UnaryOperator<Integer>unary) {
		int sum = 0;
		for(int i : a) {
			//i es el valor que recie s * 2 por así decirlo
			sum += unary.apply(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		int[]a = {1,2,3};
		System.out.println(sum(a,s -> s * 2));

	}

}
