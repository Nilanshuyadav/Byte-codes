class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int min = Integer.MAX_VALUE,profit = 0;
        
        for(int i : prices){
            if(i < min){
                min = i;
            }
            
            if(i - min > profit) profit = i - min;
        }
        
        return profit;
    }
}