package lambdas;
interface Gorilla{
	String move();
}
public class GorillaFamily implements Gorilla{
	String walk = "walk";
	void everyOnePlay(boolean baby) {
		String approach = "amble";
		
		//pasa la lambda como instancia de gorilla
		//es como si hiciera esto new Gorilla(){}como clase anonima
		//pasa las lambdas y el valor que va a devolver es walk y lo imprime
		play(()-> walk);
		play(() -> baby ? "1":"2");
		play(() -> approach);
	
	}
	void play(Gorilla g) {
		System.out.println(g.move());
	}
	public String move() {
		System.out.println(walk);
		return walk;
		
	}
}
