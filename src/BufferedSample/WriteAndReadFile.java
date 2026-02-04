package BufferedSample;
import java.io.*;
public class WriteAndReadFile {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ferna\\OneDrive\\Desktop\\output.txt"));
		//aquí guardo el contenido de cada linea
		String s;
		//esto lee linea por linea
		while((s = br.readLine()) != null) {
			System.out.println(s);
		}
	}
}
