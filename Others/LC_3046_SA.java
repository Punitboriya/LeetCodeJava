package Others;

//Input: nums = [1,1,2,2,3,4]
//Output: true
//Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].
//Example 2:
//
//Input: nums = [1,1,1,1]
//Output: false
//Explanation: The only possible way to split nums is nums1 = [1,1] and nums2 = [1,1]. Both nums1 and nums2 do not contain distinct elements. Therefore, we return false.

import java.util.HashMap;
import java.util.Map;

public class LC_3046_SA {
    public static void main(String[] args) {

        int input[] = {1, 1, 2, 2,2, 3, 4};
//        int input[] = {1, 1, 2, 2, 3, 4};
        System.out.println(isPossibleToSplit(input));
    }

    private static boolean isPossibleToSplit(int[] a) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : a) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
            if (hm.get(i) > 2) {
                return false;
            }
        }
        return true;

    }
}
