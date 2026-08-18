int missingNumber(int * nums,int n)
{   
    int j=0;
    int c=n*(n+1)/2;
    for(int i=0;i<n;i++)
    {
         j += nums[i];
    }
    int p=c-j;
   return p;
}
