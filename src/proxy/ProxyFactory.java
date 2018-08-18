package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
// ClassLoader loader 指定当前目标对象使用类加载器,获取加载器的方法是固定的
// Class<?>[] interfaces 目标对象实现的接口的类型,使用泛型方式确认类型	
//InvocationHandler h 事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
public class ProxyFactory {
	private Object target;
	public ProxyFactory(Object target) {
		this.target = target;
	}
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), 
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//执行目标对象方法
						Object value = method.invoke(target, args);
						return value;
					}
			
		});
	}
}
