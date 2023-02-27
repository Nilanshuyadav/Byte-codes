//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, n, nums, k, dp);
    }
    
    public int solve(int ind, int n, int[] nums, int k, int[] dp){
        if(ind == n-1)
            return 0;
            
        if(dp[ind] != -1) return dp[ind];
        
        int sum = 0, i=ind, min=Integer.MAX_VALUE;    
        while(i<n){
            if(sum + nums[i] > k)
                break;
            
            if(i == n-1)
                return 0;
                
            sum += nums[i]+1;
            
            min = Math.min(min, ((k-sum+1) * (k-sum+1)) + solve(i+1, n, nums, k, dp));
            i++;
        }    
        
        return dp[ind] = min;
    }
}