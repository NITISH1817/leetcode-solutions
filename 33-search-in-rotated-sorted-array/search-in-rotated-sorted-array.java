class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r)
        {
            int m=(l+r)/2;
            System.out.print(m);
            if(nums[m]==target) return m;
            if(nums[l]<=nums[m]){
                if(nums[l]<=target && nums[m]>target) r=m-1;
                else l=m+1;
            }
            else
            {
                if(nums[m]<target&&target<=nums[r]) l=m+1;
                else r=m-1;
            }
        }
        return -1;

    }
}