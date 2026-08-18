class Solution {

    public int countNumbers(int num) {
        int count = 0;

        while (num > 0) {
            num /= 10;
            count++;
        }

        return count;
    }

    public int findNumbers(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int in = countNumbers(nums[i]);

            if (in % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}