package Blind75;

import java.util.HashMap;
import java.util.Map;

public class LC01_1_TS {

    public static void main(String[] args) {

        int a[] = { 1, 8, 15, 2, 5 };
        int t = 13;

        int result[] = twoSum(a, t);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }

    public static int[] twoSum(int[] a, int t) {

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++) {
            int d = t - a[i];

            if (hm.containsKey(d)) {
                return new int[] { hm.get(d), i };
            }
            hm.put(a[i], i);

            System.out.println(hm);
        }

        return null;

    }

}
