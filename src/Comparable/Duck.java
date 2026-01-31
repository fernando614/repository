package Comparable;

import java.util.List;

public class Duck implements Comparable<Duck>{
	
	private int id;
	private String name;
	
	public Duck() {}
	public Duck(int id) {
		this.setId(id);
	}
	
	public Duck(String name) {
		this.name = name;

	}
	
	public String getName() {
		return name;
	}
	//sobre escribo equals
	public boolean equals(Object obj) {
		if(!(obj instanceof Duck)) {
			return false;
		}
		Duck other = (Duck)obj;
		return this.hashCode() == other.hashCode();
	}
	public String toString() {
		return "Name: " + name;
	}
	//en este ejemplo no entiendo para que sirve el compareTo method
	public int compareTo(Duck d) {
		//si paso enteros al objeto no funciona y lanza una excepción
		return name.compareTo(d.name);//call strings compare to
	}
	//aquí le estoy diciendo que puedo recibir lo que sea
	public void print(List<?> list) {
		for(Object obj:list) {
			System.out.println(obj);
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
