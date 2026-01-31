package Concurrency;
import java.util.concurrent.*;
public class FutureSample {
	private static int counter;
	//execptiones a tomar en cuenta throws ExecutionException, InterruptedException estas van declaradas
	public static void main(String[] args) {
		
		//creo mi service
		ExecutorService service = null;
		try {
			//creo el objeto de Executors.newSingleThreadExecutor()
			service = Executors.newSingleThreadExecutor();
			//future va a guardar si la tarea se cumple en el futuro por así decirlo
			Future<?> result = service.submit(() -> {
				for(int i = 0; i < 500; i++) {
					FutureSample.counter++;
				}
			});
			//submit.get();//si dejo así solitio el get se toma el tiempo que tome
			result.get(10,TimeUnit.SECONDS);//significa cuánto tiempo está dispuesto a esperar el hilo main
			System.out.println("task completed");
		}catch(Exception e) {
			System.out.println("task not completed");
		}
		finally {
			if(service != null) {
				service.shutdown();
			}
		}

	}

}
