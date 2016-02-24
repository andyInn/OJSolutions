package leetcodeOJ;

public class _292NimGame {
	public static boolean canWinNim(int n) {
		if(n<4)
			return true;
		int res = (n - 1) & 0x3;
		if (res == 3) {
			return false;
		}
		return true;
	}
	public static void main(String ...strings){
		System.out.println(canWinNim(1));
		System.out.println(canWinNim(2));
		System.out.println(canWinNim(3));
		System.out.println(canWinNim(4));
		System.out.println(canWinNim(5));
		System.out.println(canWinNim(6));
		System.out.println(canWinNim(7));
		System.out.println(canWinNim(8));
		System.out.println(canWinNim(9));
	}
}
