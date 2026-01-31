package Concurrency;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class MultiThreadSafe {
	/*
	 * lo que se busca hacer es que usando una variable statica podamos incrementarla
	 * con n cantidad de threads que queramos e imprimir el contador
	 * que llevamos en cada thread, pero para lograr eso sin interrupciones
	 * necesitamos usar el keyword Synchronized para que solo ejecute un thread
	 * a la vez y así incrementar e imprimir correctamente nuestro thread
	 * tambión podemos usar clases atómicas que tienen métodos synchronized
	 * los métodos y clases de cada primitivo están en mi whats
	 */
	private static Integer counter = 0;
	public static void main(String[] args) {
	
		ExecutorService service = Executors.newFixedThreadPool(10);
		//le paso una lambda runnable ya para rápido
		
		try {
			//hago un for para cada tarea que en este ejemplo son 10 para copiar y pegar 
			//service.submit()
			Lock lock = new ReentrantLock();//puedo usar lock en vez de synchronized
			for(int i = 0; i < 10; i++) {
				service.submit(() -> {
					//con synchronized evitamos que los threads se interrumpan
					//y solo se ejecute un thread hasta que el otro termine
					synchronized (service) {
						//lock.lock();
						System.out.print(++counter + " ");//output 1,2,3,4,5,6,7,8,9,10
						//lock.unlock();
					}
				});
			}
			
		}finally {
			if(service != null) {
				service.shutdown();
			}
		}
		
	}

}
