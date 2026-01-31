package lambdas;

import java.util.function.Consumer;

public class instanceMethod {
	
	public static void main(String[] args) {
		Mechanic mechanic = new Mechanic();
		Car car = new Car();
		
		//usando clase anónima
		Mechanic.execute(car,new Consumer<Car>() {
			public void accept(Car c) {
				mechanic.fix(car);
			}
		});
		//usando lamba expresion
		Mechanic.execute(car, (c) -> mechanic.fix(c));
		//usando método de referencia
		Mechanic.execute(car, mechanic::fix);
	}

}
class Car{
	private int id;
	private String color;
	
	public int getId() {
		return id;
	}
	public String getColor() {
		return color;
	}
}
class Mechanic{
	public void fix(Car car) {
		System.out.println("fixing car: " + car.getId());
	}
	public static void execute(Car car, Consumer<Car> c) {
		c.accept(car);
	}
}
