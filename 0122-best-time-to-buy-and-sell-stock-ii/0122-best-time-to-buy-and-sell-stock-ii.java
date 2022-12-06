class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        
        for(int ind=1; ind<prices.length; ind++){
            if(prices[ind] - prices[ind-1] > 0)
                ans += prices[ind]-prices[ind-1];
        }
        
        return ans;
    }
}