import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        // mark used elements in nums2
        boolean[] used = new boolean[nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // if elements match and nums2 element not already used
                if (nums1[i] == nums2[j] && !used[j]) {
                    list.add(nums1[i]);
                    used[j] = true; // mark as used
                    break;
                }
            }
        }

        // convert list to array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
