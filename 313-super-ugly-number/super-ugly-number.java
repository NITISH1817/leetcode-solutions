class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] dp = new int[n];
        int[] index = new int[k];
        long[] next = new long[k];

        dp[0] = 1;

        for (int i = 0; i < k; i++) {
            next[i] = primes[i];
        }

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                min = Math.min(min, next[j]);
            }

            dp[i] = (int) min;

            for (int j = 0; j < k; j++) {
                if (next[j] == min) {
                    index[j]++;
                    next[j] = (long) dp[index[j]] * primes[j];
                }
            }
        }

        return dp[n - 1];
    }
}