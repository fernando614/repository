package lambdas;
import java.util.function.*;
public class BinaryOperatorSample {
	//toma dos valores de tipo T,T en la función apply(T,T) que hereda de BiFunction
	public static final void main(String...args) {
		//pero esta interfaz devuelve un valor
		BinaryOperator<Integer> bo = (t,v) -> t + v;
		System.out.println(bo.apply(5, 5));
	}
}
