class Solution {
    public int numberOfCuts(int n) {
        int k=0;
        if (n==1)
        {
            return 0;
        }
        if (n%2==0){
            k=n/2;
            return k;}
        else
        {
            return n;
        }
    }
}