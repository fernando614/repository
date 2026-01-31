package Concurrencyzoo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	/*
	 * En este ejercicio busco hacer varias ordenadas sin importar si un thread 
	 * termina primero su chamba, tiene que esperar a los demás
	 * el problema se trata de que en un zoo hay 4 leones en una jaula
	 * pero primero hay que sacar a los 4 leones y luego limpiar y por último
	 * agregarlos devuelta
	 */
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		//esto es clave para que todos hagan su tarea esperando a los demás threads
		CyclicBarrier c1 = new CyclicBarrier(4);
		//aquí creo otro objeto CyclicBarrier, pero esta vez va a recibir dos parametros
		CyclicBarrier c2 = new CyclicBarrier(4,()-> System.out.println("Cage Cleaned!"));
		//creo un objeto zoo
		Zoo zoo = new Zoo();
		try {
			for(int i = 0; i < 4; i++) {
				service.submit(()-> zoo.performTaks(c1,c2));
			}
		}finally {
			if(service != null) {
				service.shutdown();
			}
		}
	}

}
