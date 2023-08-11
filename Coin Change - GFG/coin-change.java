//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        
        long[][] dp = new long[N][sum+1];
        
        for(long ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return solve(0, coins, sum, dp);
    }
    
    public long solve(int ind, int[] coins, int sum, long[][] dp){
        if(ind==coins.length){
            return sum==0?1:0;
        }
        
        if(dp[ind][sum] != -1){
            return dp[ind][sum];
        }
        
        long pick=0, not_pick=0;
        
        if(coins[ind] <= sum){
            pick = solve(ind, coins, sum-coins[ind], dp);
        }
        
        not_pick = solve(ind+1, coins, sum, dp);
        
        
        return dp[ind][sum] = pick+not_pick;
    }
}