package leetcodeOJ;

public class _9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int len = 0;
        int[] arr = new int[10];
        while (x > 0 && x % 10 >= 0) {
            arr[len++] = x % 10;
            x /= 10;
        }
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + ", " + Integer.MIN_VALUE);
        System.out.println(new _9PalindromeNumber().isPalindrome(Integer.MAX_VALUE));
        System.out.println(new _9PalindromeNumber().isPalindrome(Integer.MIN_VALUE));
        System.out.println(new _9PalindromeNumber().isPalindrome(-1));
        System.out.println(new _9PalindromeNumber().isPalindrome(10));
        System.out.println(new _9PalindromeNumber().isPalindrome(0));
        System.out.println(new _9PalindromeNumber().isPalindrome(-121));
        System.out.println(new _9PalindromeNumber().isPalindrome(-32768));
        System.out.println(new _9PalindromeNumber().isPalindrome(32767));
        System.out.println(new _9PalindromeNumber().isPalindrome(1994));
        System.out.println(new _9PalindromeNumber().isPalindrome(121));
        System.out.println(new _9PalindromeNumber().isPalindrome(100));
        System.out.println(new _9PalindromeNumber().isPalindrome(222));
        System.out.println(new _9PalindromeNumber().isPalindrome(3999));
    }
}
