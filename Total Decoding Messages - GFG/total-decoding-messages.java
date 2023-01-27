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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        int n = str.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, str, n, dp);
    }
    
    public int solve(int index, String st, int n, int[] dp){
        if(index == n)
            return 1;
            
        if(dp[index] != -1)
            return dp[index];
            
        StringBuilder sb = new StringBuilder("");
        char ch;
        int temp=0;
        
        for(int ind=index; ind<n; ind++){
            ch = st.charAt(ind);
            
            sb.append(ch);
            
            if(!valid(sb.toString())){
                break;
            }
            
            
            temp = (temp+solve(ind+1, st, n, dp))%1000000007;
        }    
        
        return dp[index] = temp;
    }
    
    public boolean valid(String sb){
        if(sb.charAt(0) == '0')
            return false;
            
        int num = Integer.valueOf(sb);
        
        return 0<num && num<27;
    }
}