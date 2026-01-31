package IO;

import java.io.Serializable;

public class Animal implements Serializable{
	
	/**
	 * 
	 */
	//importante
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "Name: " + name + " Age: " + age;
	}
	
}
