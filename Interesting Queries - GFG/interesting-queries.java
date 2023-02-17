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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int q = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int[] nums = new int[n];
            String[] S1 = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S1[i]);
            int[][] Queries = new int[q][2];
            for(int i = 0; i < q; i++){
                String[] S3 = br.readLine().trim().split(" ");
                for(int j = 0; j < S3.length; j++){
                    Queries[i][j] = Integer.parseInt(S3[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.solveQueries(nums, Queries, k);
            for(int i = 0; i < ans.length; i++)
                System.out.println(ans[i]);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] solveQueries(int[] nums, int[][] Queries, int k)
    {
        int n = nums.length;
        int[] fre = new int[1001];
        
        int l, h, j=0;
        int[] ans = new int[Queries.length];
        Set<Integer> set = new HashSet<>();
        
        for(int ind[] : Queries){
            l = ind[0];
            h = ind[1];
            set.clear();
            Arrays.fill(fre, 0);
            
            for(int i=l-1; i<h; i++){
                if(++fre[nums[i]] >= k)
                    set.add(nums[i]);
            }
            
            ans[j++] = set.size();
        }    
        
        return ans;
    }
}