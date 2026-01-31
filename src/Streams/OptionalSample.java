package Streams;
import java.util.*;
public class OptionalSample {
	
	public static void main(String[] args) {
		//esto es cuando se que optional no es nulo
		Optional<String> summary = Optional.of("book");
		String smr = summary.get();
		System.out.println(smr);
		
		Optional<String> op = Optional.ofNullable("apple");
		String fruit = op.get();
		System.out.println(fruit);
		//este solo lo usamos si sabemos que optional contiene un valor
		op.ifPresent((s) -> System.out.println(s));
		
		//aquí toma un predicate si la longitud del valor es mayor a 2 devuelve el valor si no muestra no cumple la condición
		String len = op.filter(s -> s.length() > 10).orElse("no cumple la condición");
		System.out.println(len);
	}

}
