class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int l=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<l;j++)
            {
                if(target==matrix[i][j])
                {
                    return true;
                }
            }
        }
        return false;
    }
}