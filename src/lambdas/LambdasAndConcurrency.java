package lambdas;
import java.util.List;
import java.util.concurrent.*;
public class LambdasAndConcurrency {

	public static void main(String[] args)throws Exception{
		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
		
		ExecutorService service = null;
		try {
			
			/*
			 * esta es otra manera de hacerlo 
			 * Callable<Integer> task1 = () -> list.stream().reduce(0, (a,b)-> a+b);
			   Callable<String> task2 = () -> list.stream().reduce("", (a,b)-> a+b,(i,j) -> i+j);*/
			
			service = Executors.newFixedThreadPool(2);
			//creo un hilo que me va a devolver la suma de los elementos usando reduce
			Future<Integer> sum = service.submit(() -> list.stream().reduce(0, (a,b)-> a+b));
			//ahora solo concateno los números a un string
			//List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
			Runnable r1 = () -> {
				
				System.out.println("start of the task with id = " + Thread.currentThread().getId());
				try {
					System.out.println(sum.get());
				}catch(InterruptedException | ExecutionException e) {
					//ignored
				}
				System.out.println("end of the task with id = " + Thread.currentThread().getId());
			};
			Future<String> word = service.submit(() -> list.stream().reduce("", (a,b)-> a+b,(i,j) -> i+j));
			Thread.sleep(5000);//duermo el hilo main
			/*System.out.println(sum.get());//output 
			System.out.println(word.get());//123456789*/
			Runnable r2 = () -> {
				
				System.out.println("start of the task with id = " + Thread.currentThread().getId());
				try {
					System.out.println(word.get());
				}catch(InterruptedException | ExecutionException e) {
					//ignored
				}
				System.out.println("end of the task with id = " + Thread.currentThread().getId());
			};
			//ahora voy a usar schedule
			ScheduledExecutorService serviceScheduled = Executors.newScheduledThreadPool(2);//4 hilos van a crearse
			serviceScheduled.schedule(r1, 3, TimeUnit.SECONDS);//esta tarea empieza 5 segundos después
			serviceScheduled.schedule(r2, 6, TimeUnit.SECONDS);//esta tarea empieza 5 segundos después
			
		}finally {
			if(service != null) {
				service.shutdown();
			}
		}
		
	}

}
