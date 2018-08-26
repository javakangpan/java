package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public static void main(String[] args) {
		final Outputter1 output = new Outputter1();
		new Thread() {
			public void run() {
				output.output("kangpan");
			}
		}.start();
		new Thread() {
			public void run() {
				output.output("lele");
			}
		}.start();
	}
}
class Outputter1 {
	private Lock lock = new ReentrantLock();//锁对象
	public void output(String name) {
		lock.lock();//得到锁
		try {
			for(int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
		} finally {
			lock.unlock();//释放锁
		}

	}
}