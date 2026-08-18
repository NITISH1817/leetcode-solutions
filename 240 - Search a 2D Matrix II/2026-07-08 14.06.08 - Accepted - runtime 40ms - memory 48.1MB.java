class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int l=matrix[0].length;
        for(int i=0;i<n*l;i++)
         if(matrix[i/l][i%l]==target)
            return true;
        return false;
    }
}