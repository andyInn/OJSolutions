package com.cun.practice;

/*
 http://thecodesample.com/?p=1288 
 题目描述：输入一个正整数X，在下面的等式左边的数字之间添加+号或者-号，使得等式成立。
 1 2 3 4 5 6 7 8 9 = X
 比如：
 12-34+5-67+89 = 5
 1+23+4-5+6-7-8-9 = 5
 请编写程序，统计满足输入整数的所有整数个数。
 输入： 正整数，等式右边的数字
 输出： 使该等式成立的个数
 样例输入：5
 样例输出：21

 思路：

 问题描述中提到：在等式 1 2 3 4 5 6 7 8 9 = X左边的数字之间添加+号或者-号，使得等式成立。
 当然看到例子：1+23+4-5+6-7-8-9 = 5，我们可以得到数字之间也可以不添加任何符号，所以数字之间有三种情况。

 1. 添加+号
 2.添加-号
 3.不添加任何符号，也即将数字合在一起看成一个数，如12
 我们可以采用如下两个步骤实现：

 步骤一：采用递归的方式获取数字之间添加+号，-号或者不添加任何符号的情况

 如：

 1-2+34+5678-9
 1-2+34+56789
 1-2+34-5+6+7+8+9
 1-2+34-5+6+7+8-9
 1-2+34-5+6+7+89
 1-2+34-5+6+7-8+9
 1-2+34-5+6+7-8-9
 .....
 步骤二：将步骤一中得到的字符串组合完成算术运算，然后再与期望的和值X相比较，如相等则是满足等式的一种结果

 代码如下：*/
public class PrintAllPossiableCombination {

	private int count = 0;

	public void find(int[] numbers, int fromIndex, int endIndex,
			StringBuilder currNumbersExpression, int sum, char[] symbols) {

		if (fromIndex == endIndex) {
			if (equalsToSum(currNumbersExpression, sum)) {
				count++;
				System.out.println(currNumbersExpression.toString() +
						" = " + sum);
			}
			// fromIndex == endIndex表示所有的数据已经处理完毕，直接可以返回
			return;
		}
		int tempFromIndex = fromIndex + 1;
		for (char c : symbols) {
			StringBuilder temp = new StringBuilder(
					currNumbersExpression.toString());
			if (c != ' ') {
				temp.append(c);
			}
			temp.append(numbers[tempFromIndex]);
			find(numbers, tempFromIndex, endIndex, temp, sum, symbols);
		}
	}

	private boolean equalsToSum(StringBuilder currNumbersExpression, int sum) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		boolean lastSymbolIsAdd = true;
		boolean firstNumber = true;
		for (char c : currNumbersExpression.toString().toCharArray()) {
			if (c == '+' || c == '-') {
				if (firstNumber) {
					result = Integer.parseInt(sb.toString());
					firstNumber = false;
				} else {
					// 需要根据上一次的符号计算
					if (lastSymbolIsAdd) {
						result += Integer.parseInt(sb.toString());
					} else {
						result -= Integer.parseInt(sb.toString());
					}
				}
				lastSymbolIsAdd = (c == '+');
				sb.setLength(0);

			} else {
				sb.append(c);
			}
		}
		// 最后至少包含一个数字9,需要再做一次处理
		if (lastSymbolIsAdd) {
			result += Integer.parseInt(sb.toString());
		} else {
			result -= Integer.parseInt(sb.toString());
		}
		return result == sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static void main(String[] args) {
		char[] symbols = { '+', '-', ' ' };
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		StringBuilder sb = new StringBuilder();
		sb.append(numbers[0]);
		int sum = 5;
		System.out.println("当X = " + sum + " 时满足的等式如下：");
		PrintAllPossiableCombination test = new PrintAllPossiableCombination();
		test.find(numbers, 0, numbers.length - 1, sb, sum, symbols);
		System.out.println("一共找到" + test.getCount() + "种符合条件的结果");
	}

}