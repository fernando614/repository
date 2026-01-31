package lambdas;

public class Main {

	public static void main(String[] args) {
		
		//esto haciendo con la clase GorillaFamily y no implemento la interfaz gorilla
		GorillaFamily gorilla = new GorillaFamily();
		gorilla.everyOnePlay(true);	
		//esto es cuando implemento la interfaz gorilla
		Gorilla gorilla2 = new GorillaFamily();
		gorilla2.move();
		//esto instanciando gorilla
		Gorilla g = new Gorilla() {
			public String move() {
				return "run";
			}
		};
		System.out.println(g.move());
	}

}
