package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {

	protected int countDown = 10; 
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LiftOff() {
	}

	
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiffOff!") + "),";
	}

	@Override
	public void run() {
		while(countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}

	}

	public static void main(String[] args) {
		//LiftOff liftOff = new LiftOff();
		//liftOff.run();
		//Thread thread = new Thread(new LiftOff());
		//thread.start();
		//ExecutorService exec = Executors.newCachedThreadPool();
		//ExecutorService exec = Executors.newFixedThreadPool(5);
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());			
		}
		exec.shutdown();
		
	}
}
