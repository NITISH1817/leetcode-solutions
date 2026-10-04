class Solution {
    public String getHint(String secret, String guess) {
        int[] count=new int [10];
        int bulls=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) bulls++;
            else count[secret.charAt(i)-'0']++;
        }
        int cows=0;
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)!=guess.charAt(i)){
                int digit=guess.charAt(i)-'0';
                if(count[digit]>0){
                    cows++;
                    count[digit]--;
                }
            }
        }
        return bulls+"A"+cows+"B";
    }

}