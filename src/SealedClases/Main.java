package SealedClases;
/*
 * sealed quiere decir que una clase puede heredar pero otra a lo mejor no
 * puedo usar sealed en interfaces también, pero no tengo que ponerles final sino seales nomás
 * y a las clases tiene que ser final o non-sealed y si implemento una interfaz
 * desde una clase sealed, tiene que ser la interfaz seales también
 */
sealed class A permits B,C{}
non-sealed class B extends A{}
final class C extends A implements Fly{}
// class D extends A{} con D no deja porque no le estoy dando permiso
interface Fly{}
public class Main {

	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		C c = new C();
		Fly fly = new C();
		
		boolean result = c instanceof Fly;
		System.out.println(result);
		

	}

}
