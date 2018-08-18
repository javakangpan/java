package proxy;

public class TestStaticProxy {

	/**
	 * 静态代理总结:
	1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
	2.缺点:
	因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao target = new UserDao();
		UserDaoProxy proxy = new UserDaoProxy(target);
		proxy.save();

	}

}
