package leetcodeOJ;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {
    public static void diplay(int[] arr) {
        if (null == arr || arr.length < 1) return;
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    public static void diplay(List list) {
        if (null == list || list.size() < 1) return;
        System.out.print("[");
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println(list.get(list.size() - 1) + "]");
    }

    public static <T> void diplay(Set<T> set) {
        if (null == set || set.size() < 1) return;
        System.out.print("[");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next().toString() + ",");
        }
        System.out.println("]");
    }

    public static <K, V> void diplay(Map<K, V> map) {
        if (null == map || map.size() < 1) return;
        System.out.print("[");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "->" + entry.getValue() + ",");
        }
        System.out.println("]");
    }
}
