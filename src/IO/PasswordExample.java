package IO;
import java.util.*;
import java.io.*;
import java.util.Arrays;
public class PasswordExample {

	public static void main(String[] args)throws NumberFormatException,IOException {
		//esto es como el patrón factory del capitulo 2
		Console console = System.console();
		if(console == null) {
			throw new RuntimeException("console not available");
		}
		else {
			char[] password = console.readPassword("Enter your password: ");
			console.format("Enter your password again: ");
			//no me acuerdo para que sirve este método
			console.flush();
			char[]verify = console.readPassword();
			boolean match = password.equals(verify);
			
			//limpiar las constraseñas
			for(int i = 0; i < password.length; i++) {
				password[i]='x';
			}
			for(int i = 0; i < verify.length; i++) {
				verify[i]='x';
			}
			console.format("your password is: " + (match ? "correct":"incorrect"));
		}

	}

}
