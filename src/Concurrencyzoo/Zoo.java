package Concurrencyzoo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Zoo {
	public void add() {
		System.out.println(Thread.currentThread().getId() + " adding lion");
	}
	public void cleanCage() {
		System.out.println(Thread.currentThread().getId() + " cleaning the cage");
	}
	public void remove() {
		System.out.println(Thread.currentThread().getId() + " removing lion");
	}
	public void performTaks(CyclicBarrier c1,CyclicBarrier c2) {
		try {
			remove();
			//lo pongo aquí el await para que espero a que todos terminen de sacar a los leones
			c1.await();
			cleanCage();
			//ahora se espera a que todos hayan terminando de limpiar y lanza
			//un mensaje que dice que la jaula está limpia
			c2.await();
			add();
		}catch(InterruptedException | BrokenBarrierException e) {
			//ignore
		}
	}
}
