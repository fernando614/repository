package Concurrency;
import java.util.concurrent.locks.*;
public class LockSampleTwo {
	/*
	 * lo que voy hacer en este ejemplo es usar un método que va bloquear
	 * un hilo, y el main va a tratar de acceder a ese lock
	 */
	public static void main(String[] args)throws InterruptedException {
		//creo mi lock
		Lock lock = new ReentrantLock();
		
		//creo otro thread
		new Thread(() -> acquieredLock(lock)).start();
		
		Thread.sleep(2000);
		if(lock.tryLock()) {
			System.out.println("acquired");
			lock.unlock();
		}else {
			System.out.println("not acquiered");
		}
	}
	private static void acquieredLock(Lock lock) {
		try {
			lock.lock();
		}finally {
			lock.unlock();
		}
	}
}
