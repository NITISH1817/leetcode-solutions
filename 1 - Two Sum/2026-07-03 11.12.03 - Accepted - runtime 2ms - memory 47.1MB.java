class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m=new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            int res=target-nums[i];
            if(m.containsKey(res))
            return new int[]{i,m.get(res)};
            else
            m.put(nums[i],i);
        }
        return new int[]{};
    }
}