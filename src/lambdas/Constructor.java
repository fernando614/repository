package lambdas;
import java.util.*;
import java.util.function.*;
public class Constructor {

	public static void main(String[] args) {
		//anonymusclass
		Supplier<List<String>> s = new Supplier<List<String>>() {
			public List<String> get(){
				return new ArrayList<String>();
			}
		};
		//porque devuelve una lista
		List<String> list = s.get();
		
		//ahora usando lambda
		Supplier<List<String>> s1 = () -> new ArrayList<>();
		List<String> listTwo = s1.get();
		
		//ahora usando método de referencia
		//crea la lista con solo escribir el nombre de la clase el keyword new
		Supplier<List<String>> s2 = ArrayList::new;
		List<String> listThree = s2.get();
		
		System.out.println(list + "" + listTwo + listThree);

	}

}
