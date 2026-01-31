package Concurrency;
import java.util.concurrent.*;

public class ZooInfo {

	public static void main(String[] args) {
		//no se por qué empieza como null por ahora
		ExecutorService service = null;
		try {
			//creo un solo hilo
			service = Executors.newSingleThreadExecutor();
			//main puede ser considerado otro hilo
			System.out.println("begin");
			//el hacerlo así permite que se ejecuten tareas en orden tal cual las pongo
			service.execute(() -> System.out.println("Printing zoo inventory"));
			service.execute(() -> {
				for(int i = 0; i < 3; i++) System.out.println("Printing record: " + i);
			});
			service.execute(() -> System.out.println("Printing zoo inventory"));
			System.out.println("end");
			
		}finally {
			//cuando terminel el hilo a apuntar a null y se apaga
			if(service != null) {
				service.shutdown();
			}
		}

	}

}
