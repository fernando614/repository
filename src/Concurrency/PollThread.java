package Concurrency;

public class PollThread {
	private static int count;
	
	public static void main(String[] args)throws InterruptedException {
		//creo un nuevo thread
		new Thread(() -> {
			for(int i = 0; i < 500000; i++) {
				PollThread.count++;
			}
		}).start();
		//uso un while, pero no es recomendable usar while
		while(count < 400000) {
			System.out.println("not reached");
			Thread.sleep(1);//duermo el hilo main un milisegundo y cuando despierte
			//vuelve a checar que ya se haya hecho la iteración con el for
		}
		System.out.println("reached");
	}

}
