//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        int n = s.length();
        int[] arr = new int[n];
        
        int j=0;
        for(int i=1; i<n; i++){
            if(s.charAt(j) == s.charAt(i)){
                arr[i] = ++j;
            }
            else{
                while(j!=0 && s.charAt(j)!=s.charAt(i)){
                    j = arr[j-1];
                }
                
                if(s.charAt(j) == s.charAt(i)){
                    arr[i] = ++j;
                }
            }
        }
        
        return arr[n-1];
    }
}