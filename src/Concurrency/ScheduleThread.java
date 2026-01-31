package Concurrency;
import java.util.concurrent.*;
public class ScheduleThread {

	public static void main(String[] args)throws Exception {
		//ejemplo 1 voy a poner un tiempo de 5 segundos para que se ejecute la tarea
		//uso callable para devolver algo
		Callable<String> task = () -> "eating tacos!";
		//ahora creo un runnable
		Runnable task2 = () -> System.out.println("eating pasta!");
		//creo el schedule
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			//creo que esta hereda de la interfaz future
			ScheduledFuture<String> future = service.schedule(task,5,TimeUnit.SECONDS);
			//también se puede así sin genericos
			ScheduledFuture future1 = service.schedule(task2, 10, TimeUnit.SECONDS);
			System.out.println(future.get());
		}finally {
			if(service != null) {
				service.shutdown();
			}
		}
	}

}
