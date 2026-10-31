class Solution {
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

               
                int[] right = move(grid, i, j, 0);
                if (right != null) {
                    int r = right[0], c = right[1];
                    dp[r][c] = (int) (
                        (dp[r][c] + (long) dp[i][j]) % MOD
                    );
                }
            int[] down = move(grid, i, j, 1);
                if (down != null) {
                    int r = down[0], c = down[1];
                    dp[r][c] = (int) (
                        (dp[r][c] + (long) dp[i][j]) % MOD
                    );
                }
            }
        }

        return dp[m - 1][n - 1];
    }


    private int[] move(int[][] grid, int r, int c, int dir) {
        int m = grid.length;
        int n = grid[0].length;

        while (true) {
            if (dir == 0) {
                c++;
            } else {
                r++;
            }

            if (r >= m || c >= n) {
                return null;
            }

            if (grid[r][c] == 0) {
                return new int[]{r, c};
            }

           
            dir = 1 - dir;
        }
    }
}