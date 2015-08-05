package com.cun.hashTable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Demo_hashTable {
	public static void main(String args[]) {
		Hashtable<String, Number> has = new Hashtable<String, Number>();
		has.put("one", new Integer(1));
		has.put("two", new Integer(2));
		has.put("three", new Integer(3));
		has.put("four", new Double(12.3));
		//keySet():返回此映射中包含的键的 Set 视图。
		Set<String> s = has.keySet();
		for (Iterator<String> i = s.iterator(); i.hasNext();) {
			System.out.println(has.get(i.next()));
		}
	}
}