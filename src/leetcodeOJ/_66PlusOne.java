package leetcodeOJ;

import java.util.Arrays;

public class _66PlusOne {
	public static int[] plusOne(int[] digits) {
        int len=digits.length, i=0;
		for (i = len - 1; i >= 0; i--) {
			if (digits[i] + 1 > 9) {
				digits[i] = 0;
				continue;
			} else {
				break;
			}
		}
		if(i>=0){//最高位没有进位
			digits[i] +=1;
		}else{
			len+=1;
		}
		int[] newDigits=new int[len];
		if(len==digits.length)
			newDigits=digits;
		else{
			for (int j = len-1; j >0 ; j--) {
				newDigits[j]=digits[j-1];
			}
			newDigits[0]=1;
		}
		return newDigits;
    }

	public static void main(String[] args){
		int[] digits={1,9,9};
		System.out.println(Arrays.toString(plusOne(digits)));
	}
}
