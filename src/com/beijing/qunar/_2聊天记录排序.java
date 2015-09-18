package com.beijing.qunar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class _2聊天记录排序 {
	/**
	 * Collections.sort使用了自定义排序，定义了排序函数compare，
	 * compareTo表示形参o1和o2对应属性比较的大小关系，
	 * o1.time.compareTo(o2.time)表示升序，反之为降序.
	 * Map 对所有人说话次数进行统计，可以随机访问元素，时间复杂度为O(1)
	 * @author Andy
	 *
	 */
	public static class Item{
		public String name;
		public String time;
		public String content;
	}
	
	public static List<String> sortContent(List<String> list) {
		if (list == null || list.size() == 0)
			return list;
		String[] ss;
		List<Item> listItem = new ArrayList<Item>();
		for (int i = 0; i < list.size(); i++) {
			ss = list.get(i).split("    ");
			Item item = new Item();
			item.name = ss[0];
			item.time = ss[1];
			item.content = ss[2];
			listItem.add(item);
		}
		Collections.sort(listItem, new Comparator<Item>() {
			public int compare(Item o1, Item o2) {
				return o1.time.compareTo(o2.time);
			}
		});
		list.clear();
		for (int i = 0; i < listItem.size(); i++) {
			Item e = listItem.get(i);
			list.add(e.name + "    " + e.time + "    " + e.content);
		}
		return list;
	}
	
	public static Map<String, Integer> countFrequency(List<String> list) {
		String[] ss;
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (list == null || list.size() == 0)
			return map;
		for (int i = 0; i < list.size(); i++) {
			ss = list.get(i).split("    ");
			if (!map.containsKey(ss[0])) {
				map.put(ss[0], 1);
			} else {
				map.put(ss[0], map.get(ss[0]) + 1);
			}
		}
		return map;
	}
	
	public static void main(String ...strings){
		List<String> list=new ArrayList<String>();
		list.add("张三"+"    "+"2015-10-09 19:20:08"+"    "+"11月的培训具体是从哪一天开始");
		list.add("李四"+"    "+"2015-10-09 19:01:01"+"    "+"学校的饭");
		list.add("王五"+"    "+"2015-10-09 19:01:30"+"    "+"能暂停了聊天");
		list.add("张三"+"    "+"2015-10-09 19:01:17"+"    "+"借别人的卡");
		list.add("王五"+"    "+"2015-10-09 19:21:46"+"    "+"听说是5号开始");
		list.add("赵六"+"    "+"2014-10-09 19:21:46"+"    "+"听说是8号开始");
		list.add("刘其"+"    "+"2015-10-02 23:01:23"+"    "+"听说是9号开始");
		list=sortContent(list);
		for (String string : list) {
			System.out.println(string);
		}
		Map<String, Integer> map =countFrequency(list);
//		Map<String, Integer> m=new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" :"+entry.getValue());
		}
	}
}
