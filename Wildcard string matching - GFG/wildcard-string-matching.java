//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean match(String wild, String pattern)
    {
        int w_len = wild.length(), p_len = pattern.length();
        
        Map<String, Boolean> dp = new HashMap<>();
        
        return solve(0, 0, new StringBuilder(wild), new StringBuilder(pattern), w_len, p_len, dp);
    }
    
    static boolean solve(int i, int j, StringBuilder wild, StringBuilder pattern, int w_len, int p_len, Map<String, Boolean> dp){
        if(j==p_len){
            if(i==w_len) return true;
            else{
                if(wild.charAt(i)!='*') return false;
                wild.deleteCharAt(i);
                if(solve(i, j, wild, pattern, w_len-1, p_len, dp)) return true;
                wild.insert(i, "*");
                return false;
            }
        }
        
        if(i==w_len) return false;
        
        char w = wild.charAt(i);
        char p = pattern.charAt(j);
        
        String st = ""+i+j+w;
        
        if(dp.containsKey(st)) return false;
            
        if(w!='?' && w!='*' && w!=p) {
            dp.put(st, false);
            return false;
        }    
        
        if(w==p || w=='?') return solve(i+1, j+1, wild, pattern, w_len, p_len, dp);
        else{
            wild.deleteCharAt(i);
            if(solve(i, j, wild, pattern, w_len-1, p_len, dp)) return true;
            
            wild.insert(i, p+"*");
            if(solve(i+1, j+1, wild, pattern, w_len+1, p_len, dp)) return true;
            wild.deleteCharAt(i);
        }
        
        dp.put(st, false);
        return false;
    }
}