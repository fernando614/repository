package IO;
import java.io.*;
public class PrintWritterSample {

	public static void main(String[] args)throws Exception {
		File source = new File("C:\\Users\\ferna\\OneDrive\\Desktop\\inputCopy.txt");
		//hago un wrap para mejor performance, y uso exception porque puede lanzar una exception el main
		try(PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(source)))){
			out.print("today is:");
			out.println(" saturday");
			//es como un print
			out.format("it has been raining");
			out.println();
			out.printf("using printf"+"\n");
			//usando un for
			out.println("***** TABLAS DE MULTIPLICAR *****"+"\n");
			for(int i = 1; i <= 10; i++) {
				out.println("la tabla del " + i);
				for(int j = 1; j <= 10; j++) {
					out.println(i + " * " + j + " = " + i * j);
				}
				out.println();
			}
			System.out.println("se escribio correctamente al file source!");
		}
	}

}
