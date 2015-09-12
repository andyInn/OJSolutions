package com.beijing.huawei;
//_简单错误记录
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class _简单错误记录 {
	public static class Item {
		public String name;
		public int line;

		public boolean equals(Object obj) {
			if (!(obj instanceof Item))
				return false;
			Item i = (Item) obj;
			return this.name.equals(i.name) && this.line == i.line;
		}

		public int hashCode() {
			int result = 17;
			result = 37 * result + name.hashCode();
			result = 37 * result + line;
			return result;
		}
	}
	
	public static List<Map.Entry<Item,Integer>> sortMap(Map<Item,Integer> map){
		List<Map.Entry<Item,Integer>> list=new ArrayList<Map.Entry<Item,Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Item,Integer>>() {
			public int compare(Map.Entry<Item,Integer> o1,Map.Entry<Item,Integer> o2){
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		return list;
	}
	
	public static void print(List<Map.Entry<Item,Integer>> list){
		int len=list.size()<8?list.size():8;
		for (int i = 0; i < len; i++) {
			String s=list.get(i).getKey().name;
			if(s.length()<=16)
				System.out.print(s);
			else {
				System.out.print(s.substring(s.length()-16));
			}
			System.out.println(" "+list.get(i).getKey().line+" "+list.get(i).getValue());
		}
	}
	
	public static void main(String... strings) {
		Scanner cin = new Scanner(System.in);
		Map<Item,Integer> map=new LinkedHashMap<Item, Integer>();
		String[] ss;
		int count=1;
		while(cin.hasNext()){
			Item item=new Item();
			ss=cin.nextLine().split(" ");
			if(ss[0].indexOf("\\")==-1){
				item.name=ss[0];
			}else {
				item.name=ss[0].substring(ss[0].lastIndexOf("\\")+1);
			}
			item.line=Integer.valueOf(ss[1]);
			if(!map.containsKey(item))
				map.put(item, 1);
			else {
				count=map.get(item)+1;
				map.put(item, count);
			}
		}
		//sort
		List<Map.Entry<Item,Integer>> list=sortMap(map);
		//output
		print(list);
		cin.close();
	}
}