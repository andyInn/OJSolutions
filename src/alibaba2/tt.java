package alibaba2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class tt {
	private int age;
	public static void main(String[] main){
		tt t=new tt();
		System.out.println(t.age);
		Map<String, Integer> m=new HashMap<String, Integer>();
		Map<String, Integer> m2=new Hashtable<String, Integer>();
		List<String> li=new ArrayList<String>();
		List<Integer> v=new Vector<Integer>();
		Queue<Integer> q=new LinkedList<Integer>();//LinkedList是Queue（接口）的一个实现类
		Stack<Integer> s=new Stack<Integer>();//Stack继承自Vector类,是一个类
		int k=1<<5;
		System.out.println(k);
		System.out.println(k>>>4);
	}
}
