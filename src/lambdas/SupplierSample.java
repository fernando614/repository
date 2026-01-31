package lambdas;
import java.util.function.*;
public class SupplierSample {
	
	public static void main(String[] args) {
		//solo un método llamado T get() puede devolver lo que sea
		String t = "ocp";
		//cuando no recibe nada una función se pone () solo
		Supplier<String> supplier = () -> t.toUpperCase();
		System.out.println(supplier.get());

	}

}
