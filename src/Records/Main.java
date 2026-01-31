package Records;

//creo un record
/*
 * los records ya hacen todo es decir implementan toString, equals y hashcode functions
 * todas las variables son staticas y finales lo que quiere decir que son inmutables
 * el constructor se crea de igual manera por default, pero no el implicito ese no
 * no hay getters en lugar se usa el nombre por ejemplo name(); y se accede a la propiedad
 * puedo crear funciones y variables normales pero no de instancia staticas si puedo
 */
record Person(int id, String name) {}

public class Main {
	static int age;
	public static void main(String[] args) {
		Person p1 = new Person(1,"bob");
		System.out.println(p1.name());
		
		//uso var
		var i = 0;
		for(;i<3;i++) {
			System.out.println(i);
		}
		//aquí si me deja llamarla
		age = 10;
	}

}
