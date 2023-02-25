class Solution {
    public int maxProfit(int[] prices) {
        int profit=0, min=Integer.MAX_VALUE;
        
        for(int ind : prices){
            min = Math.min(min, ind);
            
            profit = Math.max(profit, ind-min);
        }
        
        return profit;
    }
}