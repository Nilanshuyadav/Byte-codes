class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int m = offers.size();
        Collections.sort(offers, (a,b) -> a.get(0)-b.get(0));
        
        int[] dp = new int[m];
        Arrays.fill(dp, -1);
        
        return solve(0, offers, m, dp);
    }
    
    public int solve(int ind, List<List<Integer>> offers, int m, int[] dp){
        if(ind == m) return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        int pick=0, not_pick=0;
        
        
        pick = offers.get(ind).get(2) + solve(findPos(offers, offers.get(ind).get(1)+1, m), offers, m, dp);
        
        not_pick = solve(ind+1, offers, m, dp);
        
        return dp[ind] = Math.max(pick, not_pick);
    }
    
    public int findPos(List<List<Integer>> offers, int tar, int n){
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(offers.get(m).get(0) >= tar){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return h+1;
    }
}