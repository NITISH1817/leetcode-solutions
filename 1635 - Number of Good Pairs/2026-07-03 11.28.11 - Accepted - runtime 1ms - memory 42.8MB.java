class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            res += m.getOrDefault(nums[i], 0);
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}