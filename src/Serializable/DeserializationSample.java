package Serializable;
import java.io.*;
public class DeserializationSample {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\ferna\\OneDrive\\Desktop\\input.txt")))){
			
			Person p = (Person) ois.readObject();
			//aquí hago la deserialización casteando lo que vaya a leer de tipo person porque está en binarios
			System.out.println(p);
		}

	}

}
