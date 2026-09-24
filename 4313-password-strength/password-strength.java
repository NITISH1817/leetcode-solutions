class Solution {
    public int passwordStrength(String password) {
        boolean[] seen = new boolean[128];
        int score = 0;
        for (char ch : password.toCharArray()) {
            if (seen[ch])
                continue;
            seen[ch] = true;
            if (ch >= 'a' && ch <= 'z')
                score += 1;
            else if (ch >= 'A' && ch <= 'Z')
                score += 2;
            else if (ch >= '0' && ch <= '9')
                score += 3;
            else
                score += 5;
        }

        return score;
    }
}