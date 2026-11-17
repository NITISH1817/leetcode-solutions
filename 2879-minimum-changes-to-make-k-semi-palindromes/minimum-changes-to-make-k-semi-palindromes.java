import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1000000;

        int[][] cost = new int[n][n];

        // Precompute minimum changes for each substring
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                int best = INF;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;

                    for (int start = 0; start < d; start++) {
                        int left = i + start;
                        int right = i + start + (len / d - 1) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[i][j] = best;
            }
        }

        // dp[i][j] = minimum changes for first i
        // characters divided into j semi-palindromes
        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int groups = 1; groups <= k; groups++) {
            for (int i = groups * 2; i <= n; i++) {
                for (int j = (groups - 1) * 2; j <= i - 2; j++) {
                    if (dp[j][groups - 1] == INF) continue;

                    dp[i][groups] = Math.min(
                        dp[i][groups],
                        dp[j][groups - 1] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}