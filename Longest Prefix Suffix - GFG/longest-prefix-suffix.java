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
        int j=0, i=1, n=s.length(), arr[] = new int[n];
        
        while(i<n){
            if(s.charAt(j) == s.charAt(i)){
                arr[i++] = ++j;
            }
            else{
                if(j==0){
                    arr[i++] = 0;
                }
                else{
                    j = arr[j-1];    
                }
            }
        }
        
        return arr[n-1];
    }
}