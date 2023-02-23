//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        int[] dp = new int[m];
        
        int temp=1, pre=1;
        
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                
                if(grid[r][c] == 0) {dp[c] = 0; pre = 0; continue;}
                
                if(r==0){
                    if(c>0)
                        temp = pre;
                }
                else{
                    if(c>0){
                        temp = (pre + dp[c])%1000000007;
                    }
                    else{
                        temp = dp[c];
                    }
                }
                
                dp[c] = temp;
                pre = temp;
            }
        }
        
        return dp[m-1];
    }
};