class Solution {
    public int arraySign(int[] nums) {
        int pro = 1;
        for (int n : nums) {
            if (n == 0) return 0;
            if (n < 0) pro = -pro;
        }
        return pro;
    }
}
