import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] == -1)
                first[c] = i;

            last[c] = i;
        }

        List<String> ans = new ArrayList<>();
        int prev = -1;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (i != first[c])
                continue;

            int l = i, r = last[c];
            boolean ok = true;

            for (int j = l; j <= r; j++) {
                int x = s.charAt(j) - 'a';

                if (first[x] < l) {
                    ok = false;
                    break;
                }

                r = Math.max(r, last[x]);
            }

            if (ok) {
                if (l > prev)
                    ans.add(s.substring(l, r + 1));
                else
                    ans.set(ans.size() - 1, s.substring(l, r + 1));

                prev = r;
            }
        }

        return ans;
    }
}