class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int min = prices[0],profit = 0;
        
        for(int i : prices){
            if(i < min){
                min = i;
            }
            
            if(i - min > profit) profit = i - min;
        }
        
        return profit;
    }
}