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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n = nums.length;
        int pre[][] = new int[n][n], suf[][] = new int[n][n];
        for(int inx[] : pre)
            Arrays.fill(inx, -1);
        for(int inx[] : suf)    
            Arrays.fill(inx, -1);
        
        // dfs_right(1, 0, nums, suf);
        // dfs_left(n-2, n-1, nums, pre);
        
        // int max = Math.max(1+suf[1], 1+pre[n-2]);
        
        // for(int ind=1; ind<n-1; ind++){
        //     max = Math.max(max, 1+suf[ind+1]+pre[ind-1]);
        // }
        
        // for(int ind=0; ind<n; ind++){
        //     System.out.print(pre[ind]+" ");
        // }
        // System.out.println();
        
        // for(int ind=0; ind<n; ind++)
        //     System.out.print(suf[ind] + " ");
        
        int max = 0;
        
        for(int ind=0; ind<n; ind++){
            
            int left = dfs_left(ind-1, ind, nums, pre);
            int right = dfs_right(ind+1, ind, nums, suf);
            
            max = Math.max(max, (1+left+right));
        }
        
        return max;
    }
    
    public int dfs_left(int ind, int prev, int[] nums, int[][] pre){
        if(ind == -1)
            return 0;
        
        if(pre[ind][prev] != -1)
            return pre[ind][prev];
        
        int pick = 0;
        
        if(nums[ind] < nums[prev]){
            pick = 1+dfs_left(ind-1, ind, nums, pre);
        }
        
        int not_pick = dfs_left(ind-1, prev, nums, pre);
        
        return pre[ind][prev] = Math.max(pick, not_pick);
    }
    
    public int dfs_right(int ind, int prev, int[] nums, int[][] suf){
        if(ind == nums.length)
            return 0;
            
        if(suf[ind][prev] != -1)
            return suf[ind][prev];
            
        int pick = 0;
        
        if(nums[ind] < nums[prev]){
            pick = 1+dfs_right(ind+1, ind, nums, suf);
        }
        
        int not_pick = dfs_right(ind+1, prev, nums, suf);
        
        return suf[ind][prev] = Math.max(pick, not_pick);    
    }
}