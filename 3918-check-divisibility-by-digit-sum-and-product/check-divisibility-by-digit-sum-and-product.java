class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,mul=1,org=n;
        while(n!=0)
        {
            int temp=n%10;
            sum+=temp;
            mul*=temp;
            n/=10;
        }
        int res=sum+mul;
        
        if(org%res==0){
        return true;}
        return false;
    }
}