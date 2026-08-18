
        class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1, b = 2, ways = 0;

        for (int i = 3; i <= n; i++) {
            ways = a + b;
            a = b;
            b = ways;
        }

        return ways;
    }
}

    
