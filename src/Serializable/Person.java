package Serializable;

import java.io.Serializable;

//si le pongo transient quiere decir que no lo va tomar en cuenta a la hora de hacer
//la serialización
public class Person implements Serializable{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "Person {" + "name = " + name + "," + "age = " + age + "}";
	}
}
