package singleton;
/**
 * 延迟加载引入了同步关键字，在多线程环境时耗大
 * 采用内部类的方式实现单例，可以做到延迟加载，也不必使用同步关键字
 * @author kangpan
 *
 */
public class SingletonTest implements Runnable{

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			//Singleton.getInstance();
			LazySingleton.getInstance();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");
	}
}
