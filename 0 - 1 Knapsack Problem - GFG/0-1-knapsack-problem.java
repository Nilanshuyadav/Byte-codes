//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        Map<String, Integer> dp = new HashMap<>();
        
        return solve(0, W, wt, val, dp);
    } 
    
    static int solve(int ind, int W, int[] w, int[] v, Map<String, Integer> dp){
        if(ind == w.length){
            return 0;
        }
        
        String st = ""+ind+","+W;
        
        int pick=0, not_pick = 0;
        
        if(dp.containsKey(st)){
            return dp.get(st);
        }
        
        if(w[ind] <= W){
            pick = v[ind] + solve(ind+1, W-w[ind], w, v, dp);
        }
        
        not_pick = solve(ind+1, W, w, v, dp);
        
        dp.put(st, Math.max(pick, not_pick));
        
        return dp.get(st);
    }
}


