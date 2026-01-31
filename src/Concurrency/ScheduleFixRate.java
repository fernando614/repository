package Concurrency;
import java.util.concurrent.*;
public class ScheduleFixRate {

	public static void main(String[] args)throws InterruptedException {
		/*
		 * en este ejemplo voy a hacer delay al inicio del thread
		 * que voy a crear y luego voy a poner que se repita cada segundo
		 * mientras duermo el main thread por 10 segundos y luego termino 
		 * el thread que cree para que no sea infito 
		 */
		Runnable task = () -> System.out.println("eating tacos!");
		ScheduledExecutorService service = null;
		try {
			System.out.println("start of main thread");
			service = Executors.newSingleThreadScheduledExecutor();
			//le paso la tarea el delay, el tiempo por segundo en este caso y la unidad de tiempo en la que se va a volver a ejecutar
			ScheduledFuture future = service.scheduleAtFixedRate(task, 5, 1,TimeUnit.SECONDS);
			//pongo a dormir el main thread
			Thread.sleep(10_000);
			//cuando se despierte cancelo mi future thread que hice con runnable
			future.cancel(true);
		}finally {
			if(service != null) {
				service.shutdown();
			}
		}
		System.out.println("end of the main thread");

	}

}
