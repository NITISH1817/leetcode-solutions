class Solution {
    public int minMoves(int[] nums, int limit) {

        int[] diff = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {

            int low = Math.min(nums[i], nums[n - 1 - i]);
            int high = Math.max(nums[i], nums[n - 1 - i]);
            int sum = low + high;

            diff[2] += 2;
            diff[low + 1]--;
            diff[high + limit + 1]++;
            diff[sum]--;
            diff[sum + 1]++;
        }

        int ans = n;
        int moves = 0;

        for (int i = 2; i <= 2 * limit; i++) {
            moves += diff[i];
            ans = Math.min(ans, moves);
        }

        return ans;
    }
}