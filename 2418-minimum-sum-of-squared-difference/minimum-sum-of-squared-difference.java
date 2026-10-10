class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long[] count = new long[100001];
        long k = (long) k1 + k2;

        for (int i = 0; i < nums1.length; i++)
            count[Math.abs(nums1[i] - nums2[i])]++;

        for (int i = 100000; i > 0 && k > 0; i--) {
            long take = Math.min(count[i], k);
            count[i] -= take;
            count[i - 1] += take;
            k -= take;
        }

        long ans = 0;
        for (int i = 1; i <= 100000; i++)
            ans += count[i] * i * i;

        return ans;
    }
}