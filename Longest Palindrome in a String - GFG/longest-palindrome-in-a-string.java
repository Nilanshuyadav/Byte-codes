//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        int n = S.length();
        int max = 0, len_odd, len_even;
        String ans= "";
        
        for(int ind=0; ind<n; ind++){
            len_odd = findPalin(S, ind, ind, n);
            len_even = findPalin(S, ind, ind+1, n);
            
            if(max < len_odd){
                max = len_odd;
                ans = S.substring((ind-(len_odd/2)), (ind+(len_odd/2)+1));
            }
            
            if(max < len_even){
                max = len_even;
                ans = S.substring((ind-(len_even/2)+1), (ind+(len_even/2)+1));
            }
        }
        
        return ans;
    }
    
    static int findPalin(String S, int i, int j, int n){
        while(0<=i && j<n && S.charAt(i) == S.charAt(j)){
            i--;
            j++;
        }
        
        return j-i-1;
    }
}