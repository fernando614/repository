package Concurrency;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class SingleThreadExecutor {

	public static void main(String[] args) {
		//con este executorService hacemos que los hilos sean de manera síncrona
		System.out.println("start of the main thread!");
		//aquí creo las tareas
		ExecutorService service = null;
		Runnable task1 = () -> System.out.println("eat tacos");
		Runnable task2 = () -> {
			for(int i = 1; i <= 3; i++) {
				System.out.println("quantity of pizzas deliverd: " + i);
			}
		};
		try {
			//aquí creo el el hilo
			service = Executors.newSingleThreadExecutor();
			service.execute(task1);
			service.execute(task2);
		}finally {
			if(service != null) {
				//service.shutdown();//no deja que nuevas tareas entren, pero las que ya estaban si terminan
				//este método me devueleve una lista de las tareas no completadas de tipo runnable
				List<Runnable> tasksUncompleted= service.shutdownNow();
				System.out.println("tasks uncompleted: " + tasksUncompleted.size());
			}
		}
		System.out.println("end of the main thread");

	}

}
