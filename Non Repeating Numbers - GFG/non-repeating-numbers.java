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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int xor=0;
        for(int ind : nums){
            xor ^= ind;
        }
        
        int mask = xor&((~xor)+1);
        
        int bucket1=0, bucket2=0;
        
        for(int ind : nums){
            if((ind&mask) != 0){
                bucket1 ^= ind;
            }
            else{
                bucket2 ^= ind;
            }
        }
        
        return new int[]{Math.min(bucket1, bucket2), Math.max(bucket1, bucket2)};
    }
}