class Solution {
    public int maxPower(String s) {

        int maxCount = 1;
        int count = 1;
        char previous = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == previous) {
                count++;
            } else {
                previous = s.charAt(i);
                count = 1;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}