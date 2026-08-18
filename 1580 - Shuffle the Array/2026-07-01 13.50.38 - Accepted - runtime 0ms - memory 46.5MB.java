class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        int i=0,j=n,k=0;
        while (i < n) {
            arr[k]=nums[i];
            arr[k+1]=nums[j];
            i++;
            j++;
            k+=2;
        }
        return arr;
    }
}