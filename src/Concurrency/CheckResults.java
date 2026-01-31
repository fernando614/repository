package Concurrency;
import java.util.concurrent.*;
public class CheckResults {
	//variable static counter
	private static int counter = 0;
	//private static int x;
	public static void main(String[] args)throws InterruptedException {
		/*esto es por duda
		new CheckResults().x++;
		CheckResults.x++;
		x++;
		System.out.println(x); output: 3*/
		
		ExecutorService service = null;
		try {
			//creo mi tread
			service = Executors.newSingleThreadExecutor();
			//uso esta interfaz futuro que usa ? porque no va a devolver nada es void
			Future<?>result = service.submit(()-> {
				//va del 0 al 500 e incrementa count
				for(int i = 0; i<500;i++) {
					counter++;
				}
			});
			//le doy 10 segundos para que se complete la operacion del for
			result.get(1,TimeUnit.SECONDS);
			//si se logra imprime que se logró
			System.out.println("Reached!");
		}catch(Exception e) {
			//sino lo logra imprime esto
			System.out.println("Not reached in time");
		}finally {
			//shutdown() indica al Executor que no acepte más tareas y finalice cuando termine las actuales
			if(service!=null) service.shutdown();
		}

	}

}
