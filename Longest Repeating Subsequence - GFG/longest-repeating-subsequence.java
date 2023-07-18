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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        int[][] arr = new int[n+1][n+1];
        
        char chi, chj;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                chi = str.charAt(i-1);
                chj = str.charAt(j-1);
                
                if(chi==chj && i!=j){
                    arr[i][j] = arr[i-1][j-1]+1;
                }
                else{
                    if(arr[i-1][j] > arr[i][j-1]){
                        arr[i][j] = arr[i-1][j];
                    }
                    else{
                        arr[i][j] = arr[i][j-1];
                    }
                }
            }
        }
        
        return arr[n][n];
    }
}