class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int ans = 0;
        int end = -1;

        for (int i = 0; i < n; i++) {
            for (int l = i, r = i; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                if (r - l + 1 >= k && l > end) {
                    ans++;
                    end = r;
                    break;
                }
            }
            for (int l = i, r = i + 1; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                if (r - l + 1 >= k && l > end) {
                    ans++;
                    end = r;
                    break;
                }
            }
        }

        return ans;
    }
}