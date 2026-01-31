package Concurrency;
import java.util.concurrent.*;
public class CallableSample {

	public static void main(String[] args)throws Exception{
		System.out.println("start of the main thread");
		ExecutorService service = null;
		try {
			//recibe un callable de tipo integer, y le paso una lambda
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> 5+5);
			System.out.println("result: " + result.get());
		}finally {
			if(service != null) {
				service.shutdown();
			}
		}
		System.out.println("end of the main thread");
	}

}
