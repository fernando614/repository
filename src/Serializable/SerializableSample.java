package Serializable;
import java.io.*;
public class SerializableSample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//creo el objeto
		Person p = new Person("bob",22);
		System.out.println(p);
		
		try(ObjectOutputStream oos = new ObjectOutputStream
				(new BufferedOutputStream(new FileOutputStream("C:\\Users\\ferna\\OneDrive\\Desktop\\input.txt")))){
			
			oos.writeObject(p);
		}

	}

}
