class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            int[] c = new int[51];
            for (int x : nums) c[x]++;
            for (int x = 50; x >= 0; x--)
                if (c[x] == 1) return x;
            return -1;
        }
        if (k == n) {
            int max = 0;
            for (int x : nums) max = Math.max(max, x);
            return max;
        }
        int ans = -1;
        if (unique(nums, 0))
            ans = Math.max(ans, nums[0]);
        if (unique(nums, n - 1))
            ans = Math.max(ans, nums[n - 1]);
        return ans;
    }
    boolean unique(int[] nums, int index) {
        for (int i = 0; i < nums.length; i++)
            if (i != index && nums[i] == nums[index])
                return false;
        return true;
    }
}