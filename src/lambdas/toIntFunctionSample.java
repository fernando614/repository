package lambdas;
import java.util.function.*;
public class toIntFunctionSample {
	//int applyAsInt(T value); devuelve un entero 
	public static void main(String args[]) {
		ToIntFunction<String> stringToInt = Integer::parseInt;
		int i = stringToInt.applyAsInt("10");
		System.out.println(i);
	}
}
