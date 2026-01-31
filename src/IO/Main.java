package IO;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		File source = new File("C:\\Users\\ferna\\OneDrive\\Desktop\\Input.txt");
		File destination = new File("C:\\Users\\ferna\\OneDrive\\Desktop\\inputCopy.txt");
		
		//recibo una lista de readFile method
		List<String>data = readFile(source);
		//itero sobre la lista
		for(String s : data) {
			System.out.println(s);
		}
		writeFile(data,destination);
	}
	//método para leer un archivo y pasarlo a una lista
	private static List<String> readFile(File source)throws IOException{
		List<String> data = new ArrayList<String>();
		//muy importante uso buffered y dentro le paso un nuevo objeto con la referencia de source
		try(BufferedReader reader = new BufferedReader(new FileReader(source))){
			String s;
			//mientras cada caracter que tengo no se nulo lo agrego a la lista
			while((s = reader.readLine()) != null) {
				data.add(s);
			}
		
		}
		return data;
		
	}
	//método para escribir en un file
	private static void writeFile(List<String>data,File destination)throws IOException {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
			//itero sobre la lista data ya que voy a escribir
			for(String s: data) {
				//escribo lo que viene en la lista al nuevo archivo
				writer.write(s);
				//una linea nueva
				writer.newLine();
			}
			System.out.println("Write exitoso!");
		}
	}

}
