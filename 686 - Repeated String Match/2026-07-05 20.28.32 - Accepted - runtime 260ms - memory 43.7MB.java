class Solution {
    public int repeatedStringMatch(String a, String b) {

        int repeat = (int) Math.ceil((double) b.length() / a.length());

        if (a.repeat(repeat).contains(b)) {
            return repeat;
        }

        if (a.repeat(repeat + 1).contains(b)) {
            return repeat + 1;
        }

        return -1;
    }
}