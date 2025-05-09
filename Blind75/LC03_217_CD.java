package Blind75;

import java.util.HashSet;
import java.util.Set;

public class LC03_217_CD {

    public static void main(String[] args) {

        int a[] = { 1, 2, 3 ,1};
//		int a[] = {};
        System.out.println(containDuplicacte(a));

    }

    public static boolean containDuplicacte(int[] a) {

//		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
//
//		for (int i : a) {
//			if (hm.containsKey(i)) {
//				return true;
//			} else {
//				hm.put(i, 1);
//			}
//		}
//		return false;

        Set<Integer> hs = new HashSet<>();

        for (int i : a) {
            if (hs.contains(i)) {
                return true;
            } else {
                hs.add(i);
            }
        }
        return false;
    }

}
