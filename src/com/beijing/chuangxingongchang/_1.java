package com.beijing.chuangxingongchang;
/*1. 找出n个字符串中出现次数最多的字符串。

C/C++:
char* find(char **data，int n);
Java:
String find(String data[]);

说明:
1. data是字符串数组，n是数组中字符串的个数，返回值为出现次数最多的字符串。
2. 若结果有多个，返回任意一个即可
3. 不得使用任何库函数/API，如需使用类似功能, 请自行实现
4. 算法效率尽可能高，尽量少的使用内存空间
5. 必须要有代码注释和算法说明。
例如：data里面的数据是{“paper”,”cup”,”book”,”cup”,”pen”,”book”}。n = 6。返回结果为”cup”或”book”。
*/
public class _1 {
	/**
	 * 最坏的时间复杂度为O(n*n), 最好的时间复杂度为O(n)
	 * 空间复杂度O(n)
	 * @param data
	 * @return
	 */
	public static String find(String[] data) {
		if (data == null)
			return null;
		// len为数组长度值，max为最大重复次数，index为重复次数最多的元素下标
		int len = 0, max = 0, index = 0;
		for (String str : data) {// 求出数组data的长度
			len++;
		}
		if (len == 0)//错误处理
			return null;
		if (len == 1)//特殊情况处理
			return data[0];
		int[] count = new int[len];// 默认初始化记数数组为0
		for (int i = 1; i < len; i++) {
			if (max > len >> 1) {//超过数组长度的一半，直接返回结果
				return data[index];
			}
			for (int j = 0; j < i; j++) {
				if (count[j] != -1 && data[i] == data[j]) {// 找到相同的字符串了
					count[i] = -1;// "删除"重复的串
					count[j]++;// 修改此字符串的出现次数
					if (count[j] > max) {
						max = count[j];// 更新max为当前最大
						index = j;// 更新出现次数最多的字符串下标
					}
					break;
				}
			}//for
		}//for
		return data[index];
	}

	public static void main(String[] args) {
//		String[] data={"paper","cup","book","cup","pen","book"};
		String[] data={"cup","cup","cup","cup","cup"};
		System.out.println(find(data));
	}
}
