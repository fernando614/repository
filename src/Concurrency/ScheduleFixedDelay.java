package Concurrency;
import java.util.concurrent.*;
public class ScheduleFixedDelay {
	/*
	 * este código va a empezar con un delay de 5 segundos
	 * luego va imprimir start of task, duermo mi task thread por 5 segundos
	 * e imprimo end of the task y voy a pongo un gap de 1 segundo y se repite así
	 * indefinidamente a menos que yo lo cancele
	 */
	public static void main(String[] args)throws Exception {
		Runnable task = () -> {
			System.out.println("start of task");
			try {
				//pongo a dormir este task thread
				Thread.sleep(5000);
			}catch(InterruptedException e) {
				//ignore
			}
			System.out.println("end of the task");
		};
		ScheduledExecutorService service = null;
	
			service = Executors.newSingleThreadScheduledExecutor();
			//los primeros 5 segundos es el tiempo que hay que esperar para que empiece el task thread y un gap de 1 segundo
			ScheduledFuture future = service.scheduleWithFixedDelay(task, 5, 1, TimeUnit.SECONDS);
			
	}

}
