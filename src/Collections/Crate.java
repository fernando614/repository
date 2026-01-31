package Collections;

public class Crate<T,U> {
	
	private T name;
	private U age;
	
	public Crate(T name, U age) {
		this.name = name;
		this.age = age;
	}
	
	public T getName() {
		return name;
	}
	
	public U getAge() {
		return age;
	}
}
