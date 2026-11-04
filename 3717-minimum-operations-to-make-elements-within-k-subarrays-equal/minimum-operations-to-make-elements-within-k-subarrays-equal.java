import java.util.*;

class Solution {

    TreeMap<Integer, Integer> lower = new TreeMap<>();
    TreeMap<Integer, Integer> upper = new TreeMap<>();

    int lowerSize = 0, upperSize = 0;
    long lowerSum = 0, upperSum = 0;

    public long minOperations(int[] nums, int x, int k) {

        int[] maritovexi = nums;
        int n = maritovexi.length;

        long[] cost = new long[n - x + 1];

        lower.clear();
        upper.clear();
        lowerSize = upperSize = 0;
        lowerSum = upperSum = 0;

        // Calculate cost of every window
        for (int i = 0; i < n; i++) {
            add(maritovexi[i]);

            if (i >= x) {
                remove(maritovexi[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost(x);
            }
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int t = 0; t <= k; t++) {
            Arrays.fill(dp[t], INF);
        }

        Arrays.fill(dp[0], 0);

        for (int t = 1; t <= k; t++) {
            for (int i = 1; i <= n; i++) {

                // Skip current position
                dp[t][i] = dp[t][i - 1];

                // Select a window ending at i - 1
                if (i >= x && dp[t - 1][i - x] != INF) {
                    dp[t][i] = Math.min(
                        dp[t][i],
                        dp[t - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
    }

    void add(int num) {
        if (lowerSize == 0 || num <= lower.lastKey()) {
            lower.merge(num, 1, Integer::sum);
            lowerSize++;
            lowerSum += num;
        } else {
            upper.merge(num, 1, Integer::sum);
            upperSize++;
            upperSum += num;
        }

        balance();
    }

    void remove(int num) {
        if (lower.containsKey(num)) {
            removeValue(lower, num);
            lowerSize--;
            lowerSum -= num;
        } else {
            removeValue(upper, num);
            upperSize--;
            upperSum -= num;
        }

        balance();
    }

    void removeValue(TreeMap<Integer, Integer> map, int num) {
        int count = map.get(num);

        if (count == 1) {
            map.remove(num);
        } else {
            map.put(num, count - 1);
        }
    }

    void balance() {
        int target = (lowerSize + upperSize + 1) / 2;

        while (lowerSize > target) {
            int num = lower.lastKey();

            removeValue(lower, num);
            lowerSize--;
            lowerSum -= num;

            upper.merge(num, 1, Integer::sum);
            upperSize++;
            upperSum += num;
        }

        while (lowerSize < target) {
            int num = upper.firstKey();

            removeValue(upper, num);
            upperSize--;
            upperSum -= num;

            lower.merge(num, 1, Integer::sum);
            lowerSize++;
            lowerSum += num;
        }
    }

    long getCost(int x) {
        long median = lower.lastKey();

        return median * lowerSize - lowerSum
             + upperSum - median * upperSize;
    }
}