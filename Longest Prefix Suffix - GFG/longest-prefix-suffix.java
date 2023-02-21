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
        if(n==1) return 1;
        
        int[] arr = new int[n];
        int j=0,i=1;
        
        for(i=1; i<n; i++){
            if(s.charAt(i) == s.charAt(j)){
                arr[i] = j+1;
                j++;
            }
            else{
                while(j!=0 && s.charAt(j)!=s.charAt(i)){
                    j = arr[j-1];
                }
                
                if(s.charAt(j)==s.charAt(i)){
                    arr[i] = j+1;
                    j++;
                }
            }
        }
        
        return arr[n-1];
    }
}