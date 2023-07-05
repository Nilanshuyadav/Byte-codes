//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        int[][] dp = new int[n][2];
        
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return solve(0, 1, prices, dp);
    }
    
    public static int solve(int ind, int buy, int[] prices, int[][] dp){
        if(ind >= prices.length){
            return 0;
        }
        
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        
        int max;
        
        if(buy == 1){
            max = Math.max(solve(ind+1, 0, prices, dp) - prices[ind], solve(ind+1, 1, prices, dp));
        }
        else{
            max = Math.max(solve(ind+1, 1, prices, dp) + prices[ind], solve(ind+1, 0, prices, dp));
        }
        
        return dp[ind][buy] = max;
    }
}
        
