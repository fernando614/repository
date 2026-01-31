package IO;
import java.io.*;
import java.util.*;
public class ObjectStreamSample{

	/**
	 * 
	 */
	public static void main(String[] args)throws Exception {
		//creo mi lista
		List<Animal>animals = new ArrayList<Animal>();
		animals.add(new Animal("lion",10));
		animals.add(new Animal("elephant",7));
		//creo mi file
		File fileData = new File("C:\\Users\\ferna\\OneDrive\\Desktop\\Input.txt");
		//creo el animal
		createAnimals(animals,fileData);
		System.out.println(getAnimals(fileData));
	}
	private static void createAnimals(List<Animal> animals,File dataFile)throws IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))){
			//itero sobre la lista
			for(Animal animal : animals) {
				//los agrego al file
				out.writeObject(animal);
			}
		}
	}
	private static List<Animal>getAnimals(File dataFile)throws IOException,ClassNotFoundException{
		List<Animal>animals = new ArrayList<Animal>();
		//creo un wrapper de 3 niveles por así decirlo para mejorar el performance
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream
				(new FileInputStream(dataFile)))){
			while(true) {
				//esta parte no entiendo muy bien
				Object object = in.readObject();
				if(object instanceof Animal) {
					//si la referencia es de tipo animal casteo y agreo el objeto a mi lista
					animals.add((Animal)object);
				}
			}
			
		}catch(EOFException e) {
			// Fin del archivo → salida normal del loop
		}
		return animals;
	}
}
