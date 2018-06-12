package singleton;

import java.io.Serializable;

/**
 * 可以被串行化的单例
 * @author kangpan
 *
 */
public class SerSingleton implements Serializable{
	private static final long serialVersionUID = 7187181348911925149L;
	String name;
	private SerSingleton() {
		name = "SerSingleton";
		System.out.println("SerSingleton is create");
	}
	private static SerSingleton serSingleton = new SerSingleton();
	public static SerSingleton getInstance() {
		return serSingleton;
	}
	public static void createString() {
		System.out.println("createString...");
	}
	//阻止生成新的实例，总是返回当前对象,形式上构造了单例
/*	private Object readResolve() {
		return serSingleton;
	}*/
}
