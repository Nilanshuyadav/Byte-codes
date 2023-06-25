class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        
        long[][] dp = new long[n][fuel+1];
        
        for(long[] ind : dp){
            Arrays.fill(ind, -1);
        }
        
        return (int)solve(start, finish, fuel, locations, n, dp);
    }
    
    public long solve(int curr, int finish, int fuel, int[] locations, int n, long[][] dp){
        long sum=0;
        
        if(curr == finish){
            sum++;
        }
        
        if(fuel == 0){
            return sum;
        }
        
        if(dp[curr][fuel] != -1){
            return dp[curr][fuel];
        }
        
        for(int ind=0; ind<n; ind++){
            int fuel_taken = Math.abs(locations[ind] - locations[curr]);
            
            if(ind == curr || fuel_taken>fuel){
                continue;
            }
            
            sum = (sum + solve(ind, finish, fuel-fuel_taken, locations, n, dp))%1000000007;
        }
        
        return dp[curr][fuel] = sum;
    }
}