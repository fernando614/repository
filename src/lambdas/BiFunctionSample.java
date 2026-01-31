package lambdas;
import java.util.function.*;
public class BiFunctionSample {
	//para biFunction tengo que pasar los tipos de datos que voy a a pasar
	//más el valor que va a devolver
	public static void round(double d1, double d2, BiFunction<Double,Double,Long> f) {
		long result = f.apply(d1, d2);
		System.out.println(result);
	}
	public static void main(String[] args) {
		round(6.4,8.2,(t,v) -> Math.round(t+v));
	}

}
