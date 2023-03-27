//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countWaystoDivide(int N, int K) {
        int[][][] dp = new int[N+1][N+1][K+1];
        
        for(int ind[][] : dp){
            for(int inx[] : ind)
                Arrays.fill(inx, -1);
        }
        
        return solve(1, N, N, K, dp);
    }
    
    public int solve(int ind, int N, int n, int K, int[][][] dp){
        if(K==0 || ind>n || N<0){
            if(N==0 && K==0){
                return 1;
            }
            
            return 0;
        }
        
        // String st = ""+ind+","+K+","+N;
        
        // if(map.containsKey(st)){
        //     return map.get(st);
        // }
        
        if(dp[ind][N][K] != -1)
            return dp[ind][N][K];
        
        int pick = 0, not_pick = 0;
        
        pick = solve(ind, N-ind, n, K-1, dp);
        not_pick = solve(ind+1, N, n, K, dp);
        
        
        return dp[ind][N][K] = pick+not_pick;
    }
}