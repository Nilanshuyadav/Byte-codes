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
        int[][] dp = new int[n][m];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
            
        return solve(n-1, m-1, grid, n, m, dp);    
    }
    
    static int solve(int r, int c, int[][] grid, int row, int col, int[][] dp){
        if(r<0 || c<0 || r>=row || c>=col || grid[r][c]==0) return 0;
        
        if(r==0 && c==0) return 1;
        
        if(dp[r][c] != -1)  return dp[r][c];
        
        return dp[r][c] = (solve(r-1, c, grid, row, col, dp) + solve(r, c-1, grid, row, col, dp))%1000000007;
    }
};