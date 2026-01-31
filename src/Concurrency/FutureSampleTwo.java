package Concurrency;
import java.util.concurrent.*;
public class FutureSampleTwo {
	private static int count = 0;
	public static void main(String[] args)throws Exception {
		ExecutorService service = null;
		Runnable r = () -> {
			for(int i = 0; i < 500; i++) {
				count++;
			}
		};
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?>result = service.submit(r);
			//no vamos a usar get() para establecer el tiempo
		}finally {
			if(service!=null) {
				service.shutdown();
			}
		}
		//en vez de usar el clase Future uso service
		if(service!=null) {
			service.awaitTermination(1, TimeUnit.SECONDS);
			if(service.isTerminated()) {
				System.out.println("task completed");
			}else {
				System.out.println("task not completed");
			}
			
		}

	}

}
