package Concurrency;
import java.util.*;
import java.util.concurrent.*;
public class MuliThreading {

	public static void main(String[] args)throws Exception {
		//creo un callable que me va a regresar algo de tipo string
		System.out.println("start of the main thread");
		Callable<String> task= () -> "eating tacos";
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			//recibo una lista de tareas futuras tareas
			List<Future<String>> results = service.invokeAll(List.of(task,task,task));
			//aquí solo toma la primera tarea
			String result = service.invokeAny(List.of(task,task));
			System.out.println(result + " any");
			//itero sobre la lista de tareas
			for(Future future : results) {
				System.out.println(future.get());
			}
			
		}finally {
			if(service!=null) {
				service.shutdown();
			}
			
		}
		System.out.println("end of the main thread");

	}

}
