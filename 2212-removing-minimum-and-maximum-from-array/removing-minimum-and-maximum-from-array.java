class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[min]) min = i;
            if (nums[i] > nums[max]) max = i;
        }

        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }

        int a = max + 1;      
        int b = n - min;           
        int c = min + 1 + n - max; 

        return Math.min(a, Math.min(b, c));
    }
}