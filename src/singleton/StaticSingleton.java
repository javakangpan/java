package singleton;
/**
 * 采用内部类方式实现单例
 * 当StaticSingleton加载时，内部类不会被初始化，
 * 确保StaticSingleton类被载入JVM时，不会初始化单例类
 * getInstance调用时加载SingletonHolder，初始化singleton
 * @author kangpan
 *
 */
public class StaticSingleton {

	private StaticSingleton() {
		System.out.println("StaticSingleton is create");
	}
	private static class SingletonHolder {
		private static StaticSingleton singleton  = new StaticSingleton();
	}
	public static StaticSingleton getInstance() {
		return SingletonHolder.singleton;
	}
	public static void createString() {
		System.out.println("createString...");
	}
	public static void main(String[] args) {
		StaticSingleton.createString(); //createString...
		StaticSingleton.getInstance(); //StaticSingleton is create
	}
}
