package Files;

import java.io.*;

public class FileInputStreamSample {

	public static void main(String[] args)throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\ferna\\OneDrive\\Desktop\\Test.txt");
		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\ferna\\\\OneDrive\\\\Desktop\\\\newTest.txt");
		
		//readByBite(fis,fos);
		readByArray(fis,fos);
	}
	private static void readByBite(FileInputStream fis, FileOutputStream fos) throws IOException {
		//este lee por bytes y tomo un byte a la vez y luego los itero
		int b = 0;
		//cuando sea == que -1 ya termino de leer todo
		while((b = fis.read())!=-1) {
			//hago un casteo para que me ponga los caracteres y no los números
			System.out.println("Read: " + (char)b);
			fos.write(b);
		}
	}
	private static void readByArray(FileInputStream fis, FileOutputStream fos)throws IOException {
		//creo el arreglo de bites
		byte[]b = new byte[10];//obtengo solo la cantidad de bytes que quiero leer
		int count = fis.read(b);
		
		System.out.println("Read: " + count + " bytes");
		fos.write(b);
	}
	
}
