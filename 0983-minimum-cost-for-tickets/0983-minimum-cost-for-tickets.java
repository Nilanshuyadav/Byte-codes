class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, days, costs, dp);
    }
    
    public int solve(int ind, int[] day, int[] costs, int[] dp){
        if(ind >= day.length)
            return 0;        
        
        if(dp[ind] != -1)
            return dp[ind];
        
        int one=(int)1e8, seven=(int)1e8, thirty=(int)1e8;
        
        one = solve(find(day[ind]+1, day), day, costs, dp) + costs[0];
        seven = solve(find(day[ind]+7, day), day, costs, dp) + costs[1];
        thirty = solve(find(day[ind]+30, day), day, costs, dp) + costs[2];

        return dp[ind] = Math.min(one, Math.min(seven, thirty));
    }
    
    public int find(int target, int[] day){
        int l=0, h=day.length-1, m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(day[m] == target){
                return m;
            }
            else if(day[m] < target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return l;
    }
}