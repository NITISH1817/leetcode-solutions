int  moveZeroes(int* nums, int numsSize) {
int count=0,i;
    for(i=0;i<numsSize;i++)
    {
        if(nums[i]!=0)
        {
            nums[count++]=nums[i];
        }
    }
    for(i=count;i<numsSize;i++)
    {
        nums[i]=0;  
    }
    return 0;
}
