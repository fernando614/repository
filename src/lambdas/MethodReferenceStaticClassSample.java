package lambdas;
import java.util.*;
import java.util.function.BiPredicate;
public class MethodReferenceStaticClassSample {
	public static boolean isMoreThanFifty(int x, int y) {
		return x + y > 50;
	}
	public static List<Integer>findNumbers(List<Integer>list,BiPredicate<Integer,Integer>p){
		List<Integer>newList = new ArrayList<>();
		for(int i : list) {
			if(p.test(i, i + 10)) {
				newList.add(i);
			}
		}
		return newList;
	}
	public static void main(String[] args) {
		List<Integer>list = Arrays.asList(5,24,22,49);
		//usando clase anónima
		System.out.println("usando clase anónima: " + findNumbers(list,new BiPredicate<Integer,Integer>(){
			//aquí recibe objetos Integer no primitivos
			public boolean test(Integer x, Integer y) {
				return MethodReferenceStaticClassSample.isMoreThanFifty(x, y);
			}
		}));
		//usando lambda
		System.out.println("using lambda expression: " + findNumbers(list,(t,v) ->  MethodReferenceStaticClassSample.isMoreThanFifty(t,v)));
		//usando method reference
		System.out.println("usging method reference: " + findNumbers(list,MethodReferenceStaticClassSample::isMoreThanFifty));
	}

}
