class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int x = i;
            boolean good = false;
            boolean valid = true;

            while (x > 0) {
                int d = x % 10;

                if (d == 3 || d == 4 || d == 7) {
                    valid = false;
                    break;
                }

                if (d == 2 || d == 5 || d == 6 || d == 9)
                    good = true;

                x /= 10;
            }

            if (valid && good)
                ans++;
        }

        return ans;
    }
}