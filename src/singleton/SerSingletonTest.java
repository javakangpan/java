package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.jupiter.api.Test;
//import junit.framework.Assert;

class SerSingletonTest {

	@Test
	void test() throws Exception {
		SerSingleton s1 = null;
		SerSingleton s = SerSingleton.getInstance();
		FileOutputStream out = new FileOutputStream("../SerSingleton.txt");
		ObjectOutputStream oo = new ObjectOutputStream(out);
		oo.writeObject(s);
		out.close();
		out.flush();
		FileInputStream in = new FileInputStream("../SerSingleton.txt");
		ObjectInputStream oi = new ObjectInputStream(in);
		s1 = (SerSingleton) oi.readObject();
		String str1 = s1.toString();
		String str = s.toString();
		//注释readResolve方法 返回false
		System.out.println(str1.equals(str));
		//Assert.assertEquals(s1, s);		
	}
}
