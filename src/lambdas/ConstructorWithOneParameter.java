package lambdas;
import java.util.function.*;
public class ConstructorWithOneParameter {

	public static void main(String[] args) {
		//usando anonymus
		Function<String,Integer> f = new Function<String,Integer>(){
			public Integer apply(String s) {
				return new Integer(s);
			}
		};
		Integer i = f.apply("10");
		System.out.println(i);
		
		//usando lambda
		Function<String,Integer> f1 = (s) -> new Integer(s);
		Integer j = f1.apply("20");
		System.out.println(j);
		
		//usando método de referencia
		Function<String,Integer> f2 = Integer::new;
		Integer z = f2.apply("30");
		System.out.println(z);
	}

}
