package Concurrency;
import java.util.Random;
import java.util.concurrent.*;
public class MultiThreadPools {
	//llamo a random para crear un número random
	private static Random random = new Random();
	/*
	 * en este ejemplo lo que busco es correr multiples threads al mismo tiempo
	 * y también ponerles un sleep y crear un número aleatorio para que no duren lo mismo
	 * también voy a usar schedule para dar un tiempo de inicio para que comience
	 * cada thread ok
	 */
	public static void main(String[] args) {
		//creo mi task
		Runnable task = ()->{
			//genero número random
			int sleepTime = random.nextInt(20);
			System.out.println("start of the task with id = " + Thread.currentThread().getId() + " (this task will take " + sleepTime + " seconds)");
			try {
				Thread.sleep(sleepTime*1000);
			}catch(InterruptedException e) {
				//ignored
			}
			System.out.println("end of the task with id = " + Thread.currentThread().getId());
		};
		
		//creo el ExecutorService con un objeto FixedThreadPool que lo que hace es recibir la cantidad de hilos que va a ejecutarse
		//ExecutorService service = Executors.newFixedThreadPool(4);
		//hace lo mismo que el de arriba pero cada vez que haga submit sabe que tiene que crear un nuevo hilo
		ExecutorService service = Executors.newCachedThreadPool();
		//envio las 4 tareas en paralelo
		/*service.submit(task);
		service.submit(task);
		service.submit(task);
		service.submit(task);*/
		
		//ahora voy a usar schedule
		ScheduledExecutorService serviceScheduled = Executors.newScheduledThreadPool(4);//4 hilos van a crearse
		serviceScheduled.schedule(task, 5, TimeUnit.SECONDS);//esta tarea empieza 5 segundos después
		serviceScheduled.schedule(task, 6, TimeUnit.SECONDS);//esta tarea empieza 6 segundos después
		serviceScheduled.schedule(task, 7, TimeUnit.SECONDS);//esta tarea empieza 7 segundos después
		serviceScheduled.schedule(task, 8, TimeUnit.SECONDS);//esta tarea empieza 8 segundos después
	}

}
