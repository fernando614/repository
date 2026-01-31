package lambdas;
import java.util.function.*;
public class PredicateSample {

	public static void main(String[] args) {
		//version anonymusclass
		Predicate<String> p1 = new Predicate<String>() {
			@Override
			public boolean test(String s) {
				return s.startsWith("A");
			}
		};
		boolean resultP1 = p1.test("HI");
		System.out.println(resultP1);//output false
		//mismo ejemplo pero con lambda
		Predicate<String> p2 = s -> s.startsWith("A");
		System.out.println(p2.test("Peter"));
		
		Predicate<String> p3 = s -> s.startsWith("H");
		Predicate<String> p4 = s -> s.endsWith("A");
		boolean resultP3AndP4 = p3.or(p4).test("HI");
		//da true porque compara, el método or o and son de predicate
		System.out.println(resultP3AndP4);

	}

}
