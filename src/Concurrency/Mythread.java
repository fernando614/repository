package Concurrency;
//lo ideal es implementar la intefaz runnable
public class Mythread{
	
	public static void main(String[] args) {
		//otra manera de hacerlo pero usando clase anónima
		Runnable r = new Runnable(){
			int i = 1;
			public void run() {
				while(i <= 10) {
					System.out.println(i);
					i++;
				}
			}
		};
		//aquí se crean dos hilos el primero es el del main
		System.out.println("start of main thread");
		//el segundo en ejecutarse es este
		Thread thread = new Thread(r);
		thread.start();
		System.out.println("end of main thread");
		
		//otra manera de hacerlo pasarle la lambda como tal porque ya sabe que tiene runnable
		new Thread(() -> {
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		}).start();
		
	}

}
