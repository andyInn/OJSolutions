package com.cun.practice;
/**
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

思路整理一下：
首先交待一下异或的基本性质：2个相同的数异或等于0，且异或操作(^)满足结合律和交换律。
再来考虑一种简单一点的情况：一个数组中只有一个元素出现唯一的一次，而有其他元素都出现2次。
那么我们用0依次异或数组中每一个元素，得到的就是那个唯一的元素。因为我们可以利用交换律和结合律将相同的元素移动到一起，那么在利用结合律，相同的元素两两先异或，得到0，最后得到很多0和唯一的元素异或，所以最终的答案就是那个唯一的元素。

所以，如果我们能把原来问题中的数组，分成2个子数组，使得每个子数组中都只有一个唯一的元素以及很多成对的元素，那么我们就可以求出每个子数组中唯一的元素，最终就可以得到原数组中2个出现次数唯一的元素。
方法是这样的：
1. 首先数组中所有元素依次异或，因为相同的元素异或得到0，所以最终的答案就等于那2个唯一的元素a^b的值。
2. 因为a,b不同，所以异或得到的答案肯定是不等于0的，那么我们就找到a^b的二进制表示中第一个为1的位，假如是第k位。而a,b两个数在第k位上是不同的，一个为0，一个为1
3. 接下来我们将第k位是1的分成一组，第k位是0的分成一组，如果2个元素相同，那么他们第k位肯定是一样的，所以肯定被分到同一组中。而a,b则被分到2组中去了。

然后我们就可以在每个分组中异或每一个元素，最终就可以得到那2个唯一的元素。
 * @author Andy
 *
 */
public class FindTwoNumsAppearOnce {
	public static int getFirstOne(int num) {
		int pos = 1;
		while ((num & 0x01) == 0) {
			num = num >> 1;
			pos++;
		}
		return pos;
	}

	public static boolean isOne(int num, int pos) {
		num = num >> (pos - 1);
		return (num & 0x01) == 1;
	}
	
	public static void getNum(int[] a, int num1, int num2) {
		int pivot = 0, len=a.length;
		for (int i = 0; i < len; i++) {
			pivot ^= a[i];
		}
		int pos = getFirstOne(pivot);
		for (int i = 0; i < len; i++) {
			if (isOne(a[i], pos)) {
				num1 ^= a[i];
			} else {
				num2 ^= a[i];
			}
		}//for
		System.out.println("'num1' is:" + num1 + ", 'num2' is:" + num2);
	}

	public static void main(String[] args){	
		int num1 = 0,num2 = 0;
//		System.out.println(1&0x2);
//		System.out.println(isOne(11,2));
		int[] a = {3,2,3,1,4,2,7,4,5,9,5,9};
		getNum(a, num1, num2);
	}
}
