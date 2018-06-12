package singleton;
/**
 * 单例模式
 * @author kangpan
 *
 */
public class Singleton {
	private Singleton() {
		System.out.println("Singleton is create");
	}
	private static Singleton singleton = new Singleton();
	public static Singleton getInstance() {
		return singleton;
	}
	public static void createString() {
		System.out.println("createString...");
	}
	/**
	 * 控制台打印：
	 * Singleton is create
	 * createString...
	 * 虽然没有使用单例类，但它还是被创建出来
	 * 为了提高系统性能，采用延迟加载
	 * @param args
	 */
	public static void main(String[] args) {
		Singleton.createString();
	}
}

