package lambdas;
import java.util.function.*;
public class FunctionSample {
	//toma dos valores la interfaz function y el segundo es el que va a devolver
	public static void round(double d, Function<Double,Long>f) {
		long result = f.apply(d);
		System.out.println(result);
	}
	public static void main(String args[]) {
		//esto esta bien le paso la lamba
		round(5.0, s -> Math.round(s));
		//también puedo hacer esto
		Function<Double,Long> f = s -> Math.round(s);
		round(9.7,f);
		
		Function<String,String> f1 = s -> s.toLowerCase();
		Function<String,String> f2 = s -> s.substring(1,5);
		String name = f1.apply("FERNANDO");
		String name2 = f2.apply(name);
		System.out.println(name);
		System.out.println(name2);
	}
}
