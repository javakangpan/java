package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		
		List<String> a = new LinkedList<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		
		List<String> b = new LinkedList<String>();
		b.add("1");
		b.add("2");
		b.add("3");
		b.add("4");
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		while(bIter.hasNext()) {
			String str = bIter.next();
			if(aIter.hasNext()) {
				aIter.next();
				aIter.add(str);
			}
		}
		System.out.println(a);
		
		bIter = b.iterator();
		while(bIter.hasNext()) {
			bIter.next();
			bIter.remove();
		}
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
	}

}
