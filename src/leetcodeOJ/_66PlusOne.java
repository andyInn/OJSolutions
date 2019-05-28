package leetcodeOJ;

public class _66PlusOne {
    public int[] plusOne(int[] digits) {
        if (null == digits || digits.length < 1) return new int[]{1};
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) sum += (digits[i] + 1);
            else sum += digits[i];
            sb.append(sum >= 10 ? sum % 10 : sum);
            sum /= 10;
        }
        if (sum > 0) sb.append(sum);
        int[] r = new int[sb.length()];
        for (int i = 0; i < r.length; i++) {
            r[i] = Integer.parseInt(sb.substring(r.length - 1 - i, r.length - i));
        }
        return r;
    }

    public static void main(String[] args) {
        Utils.diplay(new _66PlusOne().plusOne(new int[]{1,2,3}));
        Utils.diplay(new _66PlusOne().plusOne(new int[]{1,2,9}));
        Utils.diplay(new _66PlusOne().plusOne(new int[]{1}));
        Utils.diplay(new _66PlusOne().plusOne(new int[]{}));
        Utils.diplay(new _66PlusOne().plusOne(new int[]{0,0,0,0}));
        Utils.diplay(new _66PlusOne().plusOne(new int[]{9,9}));
        Utils.diplay(new _66PlusOne().plusOne(new int[]{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}));
    }
}
