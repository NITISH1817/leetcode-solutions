class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String s = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    temp.append(count).append(s.charAt(j - 1));
                    count = 1;
                }
            }
            // Append the last group
            temp.append(count).append(s.charAt(s.length() - 1));
            s = temp.toString();
        }
        return s;
    }
}
