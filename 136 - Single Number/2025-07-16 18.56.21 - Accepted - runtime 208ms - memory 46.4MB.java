class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int d=0;
            for(int j=0;j<n;j++)
            {
                if(nums[i]==nums[j] && i!=j)
                {
                    d=1;
                    break;
                }
            }
            if(d==0)
            {
                return nums[i];
            }
        }
    
    return 23;
    }
}