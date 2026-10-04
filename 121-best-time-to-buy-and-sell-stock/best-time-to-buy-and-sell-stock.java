class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,min=prices[0]; 
        for(int price:prices){
        min=Math.min(min,price);
        profit=Math.max(profit,price-min);}
        return profit;
    }
}