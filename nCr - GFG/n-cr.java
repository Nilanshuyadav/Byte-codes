//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        long[][] dp = new long[n+1][r+1];
        
        for(long ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return (int)solve(n, r, dp);
    }
    
    static long solve(int n, int r, long[][] dp){
        if(n<r){
            return 0;
        }
        if(r == 0 || n == r){
            return 1;
        }
        
        if(dp[n][r] != -1){
            return dp[n][r];
        }
        
        long one=0,two=0;
        
        one = solve(n-1, r-1, dp);
        two = solve(n-1, r, dp);
        
        return dp[n][r] = (one+two)%1000000007;
    }
}