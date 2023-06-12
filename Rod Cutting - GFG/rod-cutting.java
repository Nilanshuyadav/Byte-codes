//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[] dp = new int[n+1];
        
        Arrays.fill(dp, -1);
        
        return solve(n, price, dp);
    }
    
    public int solve(int size, int[] price, int[] dp){
        if(size == 0){
            return 0;
        }
        
        if(dp[size] != -1){
            return dp[size];
        }
        
        int max = 0;
        for(int ind=1; ind<=size; ind++){
            max = Math.max(max, price[ind-1] + solve(size-ind, price, dp));
        }
        
        return dp[size] = max;
    }
}