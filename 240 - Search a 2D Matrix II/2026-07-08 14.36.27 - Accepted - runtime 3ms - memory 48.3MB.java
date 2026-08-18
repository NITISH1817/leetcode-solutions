class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int l=matrix[0].length;
        int left=0,right=l-1;
        while(left<n && right>=0)
        {
            if(matrix[left][right]==target)
            {
                return true;
            }
            if(target<matrix[left][right])
            {
                right--;
            }
            else
            {
                left++;
            }

        }
        return false;
    }
}