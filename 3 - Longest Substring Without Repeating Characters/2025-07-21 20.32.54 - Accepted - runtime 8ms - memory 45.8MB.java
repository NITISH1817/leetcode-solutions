import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));
            if (temp.contains(ch)) {
                temp = temp.substring(temp.indexOf(ch) + 1);
            }
            temp += ch;
            if (temp.length() > max) {
                max = temp.length();
            }
        }

        return max;
    }
}
