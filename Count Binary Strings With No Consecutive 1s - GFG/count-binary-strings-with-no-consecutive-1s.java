//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            long N = Long.parseLong(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.countStrings(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countStrings(long N) {
        // Code here
        return pow(N)[0][0];
    }
    
    public int[][] pow(long N){
        if(N==1){
            return new int[][]{{2,1},{1,1}};
        }
        
        if((N&(1<<0)) == 0){
            return matrixMultiply(pow(N-1), new int[][]{{1,1},{1,0}});
        }
        
        int[][] temp = pow(N/2);
        return matrixMultiply(temp, temp);
    }
    
    public int[][] matrixMultiply(int[][] a, int[][] b){
        int[][] ans = new int[2][2];
        
        ans[0][0] = (int)(((long)a[0][0]*b[0][0] + (long)a[0][1]*b[1][0])%1000000007);
        ans[0][1] = (int)(((long)a[0][0]*b[0][1] + (long)a[0][1]*b[1][1])%1000000007);
        ans[1][0] = (int)(((long)a[1][0]*b[0][0] + (long)a[1][1]*b[1][0])%1000000007);
        ans[1][1] = (int)(((long)a[1][0]*b[0][1] + (long)a[1][1]*b[1][1])%1000000007);
        
        return ans;
    }
}