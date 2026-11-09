class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();

        int time = 0;

        for (int i = k; i < n; i += k) {
            time++;

            if (word.substring(i).equals(word.substring(0, n - i))) {
                return time;
            }
        }

        return (n + k - 1) / k;
    }
}