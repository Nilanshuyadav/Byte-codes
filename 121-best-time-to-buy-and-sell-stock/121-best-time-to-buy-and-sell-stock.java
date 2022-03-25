class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        int min = Integer.MAX_VALUE;
        int p = 0;
        
        for(int i=0;i<n;i++){
            if(prices[i]<min) min = prices[i];
            if(prices[i] - min > p) p = prices[i]-min;
            
        }
        
        return p;
    }
}