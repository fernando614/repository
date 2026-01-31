package lambdas;
import java.util.function.*;
public class BiPredicateSample {

	public static void main(String[] args) {
		//toma dos parametros t o v que quiere decir cualquier tipo
		BiPredicate<Integer,Integer> divisible = (t,u) -> t % u == 0;
		boolean result = divisible.test(10, 5);
		System.out.println(result);

	}

}
