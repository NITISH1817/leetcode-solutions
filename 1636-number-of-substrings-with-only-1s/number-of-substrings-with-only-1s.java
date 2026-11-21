class Solution {
    public int numSub(String s) {
        int mod = 1_000_000_007;
        long count = 0;
        long ans = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
                ans = (ans + count) % mod;
            } else {
                count = 0;
            }
        }

        return (int) ans;
    }
}