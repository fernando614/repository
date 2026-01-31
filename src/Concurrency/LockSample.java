package Concurrency;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class LockSample {
	/*
	 * en este ejemplo lo que voy a hacer usar lock en vez de synchronize y 
	 * algunos ejemplos
	 */
	private static int counter; 
	public static void main(String args[]) {
		//creo mi lock
		Lock lock = new ReentrantLock();
		//creo mi service executor
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		try {
			for(int i = 0; i < 10; i++) {
				//agrego otro try finally para el lock
				try {
					//se hace esto en vez de synchronized
					lock.lock();
					System.out.print(++counter+" ");
				}finally {
					lock.unlock();
				}
			}
		}finally{
			if(service != null) {
				service.shutdown();
			}
		}
	}
}
