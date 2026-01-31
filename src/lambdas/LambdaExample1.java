package lambdas;

public class LambdaExample1 {
	public void anonima() {
		//version con clase anónima
		//no puedo cambiar reasignar a una variable local porque es final
		//y me puede dar un error de compilacion
		int localVariable = 10;
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("anonymus class -> " + localVariable);
			}
		};
		r.run();
	}
	//version con lambda
	public void lambda() {
		int localVariable = 10;
		Runnable r = () -> {
			System.out.println("lambda -> " + localVariable);
		};
		//no compila -> localVariable = 20;
		r.run();
	}
	public static void main(String args[]) {
		LambdaExample1 test = new LambdaExample1();
		test.anonima();
		test.lambda();
	}
	
}
