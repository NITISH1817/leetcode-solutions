class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        Arrays.fill(best, 1000000);

        int left = 0, sum = 0, ans = 1000000;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target)
                sum -= arr[left++];

            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && best[left - 1] != 1000000)
                    ans = Math.min(ans, len + best[left - 1]);

                best[right] = len;
            }

            if (right > 0)
                best[right] = Math.min(best[right], best[right - 1]);
        }

        return ans == 1000000 ? -1 : ans;
    }
}