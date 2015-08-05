package jiuDuOJ;


public class Main5 {
	public static void main(String[] args)

	{
		String string;
		int a = 5;
		int x = 2;
		string = Integer.toBinaryString(a); // 把int型数据转换乘X进制数并转换成二进制型
		System.out.println(string);
//		System.out.println(string ^ Integer.toBinaryString(4));
		System.out.println(~4);

		int b = Integer.parseInt(string, x);// 把字符串当作X进制数转换成int型
		System.out.println(b);
	}
}