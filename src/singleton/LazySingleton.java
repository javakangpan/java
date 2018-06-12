package singleton;

/**
 * 采用延迟加载 
 * @author kangpan
 *
 */
public class LazySingleton{
	private LazySingleton(){
		System.out.println("LazySingleton is create");
	}
	private static LazySingleton singleton = null;
	public static synchronized LazySingleton getInstance() {
		if(null == singleton) {
			singleton = new LazySingleton();
		}
		return singleton;
	}
	public static void createString() {
		System.out.println("createString...");
	}
	/**
	 * 控制台打印：
	 * createString...
	 * @param args
	 */
	public static void main(String[] args) {
		LazySingleton.createString();
	}
}
