package leetcodeOJ;

import java.util.*;

public class _17_Letter_Combinations_of_a_Phone_Number {
    private static final String[][] arr = {
            {"a", "b", "c", ""},
            {"d", "e", "f", ""},
            {"g", "h", "i", ""},
            {"j", "k", "l", ""},
            {"m", "n", "o", ""},
            {"p", "q", "r", "s"},
            {"t", "u", "v", ""},
            {"w", "x", "y", "z"}
    };

    public List<String> letterCombinations(String digits) {
        List<String> r = new ArrayList<>();
        if (null == digits || digits.length() < 1) return r;
        Set<String> s = new HashSet<>();
        s.addAll(Arrays.asList(arr[Integer.parseInt(digits.substring(digits.length() - 1, digits.length())) - 2]));
        s.remove("");
        for (int i = digits.length() - 2; i >= 0; i--) {
            if (r.size() > 0) {
                s.clear();
                s.addAll(r);
                r.clear();
            }
            int index = Integer.parseInt(digits.substring(i, i + 1)) - 2;
            Iterator<String> it = s.iterator();
            while (it.hasNext()) {
                String t = it.next();
                for (int j = 0; j < 4; j++) {
                    if ("" != arr[index][j]) r.add(arr[index][j] + t);
                }
            }
        }
        if (r.size() == 0) r.addAll(s);
        Collections.sort(r, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations("23"));
        System.out.println(new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations(""));
        System.out.println(new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations("6"));
        System.out.println(new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations("7"));
        System.out.println(new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations("78"));
        System.out.println(new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations("79"));
        System.out.println(new _17_Letter_Combinations_of_a_Phone_Number().letterCombinations("22995"));
    }
}
