import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);

        int m = restrictions.length;
        int[][] r = new int[m + 2][2];

        // Add building 1 with height 0
        r[0][0] = 1;
        r[0][1] = 0;

        // Copy restrictions
        for (int i = 0; i < m; i++) {
            r[i + 1] = restrictions[i];
        }

        // Add building n with maximum possible height
        r[m + 1][0] = n;
        r[m + 1][1] = n - 1;

        // Left to right: enforce height limits
        for (int i = 1; i < m + 2; i++) {
            int distance = r[i][0] - r[i - 1][0];
            r[i][1] = Math.min(r[i][1], r[i - 1][1] + distance);
        }

        // Right to left: enforce height limits
        for (int i = m; i >= 0; i--) {
            int distance = r[i + 1][0] - r[i][0];
            r[i][1] = Math.min(r[i][1], r[i + 1][1] + distance);
        }

        int maxHeight = 0;

        // Find maximum possible height between restrictions
        for (int i = 0; i < m + 1; i++) {
            int distance = r[i + 1][0] - r[i][0];
            int height = (r[i][1] + r[i + 1][1] + distance) / 2;

            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;
    }
}