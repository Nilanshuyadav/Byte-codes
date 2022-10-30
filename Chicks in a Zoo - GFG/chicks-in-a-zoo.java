//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
        long alive=1;
        long[] dp = new long[N+1];
        dp[1] = 1;
        
        for(int ind=2; ind<=N; ind++){
            if(ind<7){
                alive *= 3;
                dp[ind] = alive;
            }
            
            else if(ind==7){
                long diff = dp[ind-6]-dp[ind-7];
                
                alive = (alive-diff)*3;
                dp[ind] = alive;
            }
            
            else{
                dp[ind]=dp[ind-1]*3-dp[ind-6]*2;
            }
        }
        
        
        return dp[N];
         
    }
}