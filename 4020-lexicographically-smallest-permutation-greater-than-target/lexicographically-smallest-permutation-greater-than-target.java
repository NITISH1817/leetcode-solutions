class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int n = s.length();
        StringBuilder prefix = new StringBuilder();

        // Match the longest possible prefix of target
        for (int i = 0; i < n; i++) {
            int index = target.charAt(i) - 'a';

            if (freq[index] == 0) {
                break;
            }

            freq[index]--;
            prefix.append(target.charAt(i));
        }

        // Backtrack and find the smallest greater character
        for (int i = prefix.length(); i >= 0; i--) {

            if (i < prefix.length()) {
                freq[prefix.charAt(i) - 'a']++;
            }

            if (i == n) {
                continue;
            }

            int targetIndex = target.charAt(i) - 'a';

            for (int j = targetIndex + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    freq[j]--;

                    StringBuilder ans = new StringBuilder();
                    ans.append(prefix.substring(0, i));
                    ans.append((char) ('a' + j));

                    // Append remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}