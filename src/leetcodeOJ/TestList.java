package leetcodeOJ;

import java.util.*;

public class TestList{
	public static void main(String[] args){
		//List<Character> list = new ArrayList<Character>();
		String[] str = "a b c".split(" ");	
		System.out.println("字符串数组str,长度为：" + str.length);
		for(String c : str)
			System.out.println(c);
			
			
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Iterator<Integer> it = list.iterator();
		System.out.println("整型List list");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		//数组转换成List
		List<String> li = new ArrayList<String>();
		li = Arrays.asList(str);       
		Iterator<String> its = li.iterator();
		System.out.println("数组str -> list：");
		while(its.hasNext())
		{
			System.out.println(its.next());
		}
		
		//List转换成数组
		Integer[] b = (Integer[])list.toArray(new Integer[0]);
		System.out.println("List list -> 数组b");
		for(Integer i : b)
			System.out.println(i);
		
		//数组的fill方法
		int[] a = new int[5];
		Arrays.fill(a,0);
		System.out.println("数组a被0填充");
		for(int i : a)
			System.out.println(i);			
	}
}
