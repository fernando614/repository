package ExercisesForFun;

public class Tables {
	public static void getTables(int n) {
		for(int i = 1; i <= n; i++) {
			System.out.println("La tabla del: " + i);//1
			for(int j = 1; j <= 10; j++) {
				System.out.println(i + " * " + j + " es igual a: " + (i * j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		//getTables(2);
		

	}

}
