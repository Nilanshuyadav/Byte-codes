//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        
        for(int ind=0; ind<row; ind++){
            if(grid[ind][0] == 1)
                boundaries(ind, 0, grid);
            if(grid[ind][col-1] == 1)
                boundaries(ind, col-1, grid);
        }
        
        for(int ind=0; ind<col; ind++){
            if(grid[0][ind] == 1)
                boundaries(0, ind, grid);
            if(grid[row-1][ind] == 1)
                boundaries(row-1, ind, grid);
        }
        
        int ans=0;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++)
                if(grid[r][c] == 1)
                    ans++;
        }
        
        return ans;
    }
    
    public void boundaries(int r, int c, int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        
        int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(r,c));
        grid[r][c] = 0;
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int ind=0; ind<4; ind++){
                int new_row = temp.row+r_arr[ind];
                int new_col = temp.col+c_arr[ind];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]==0)
                    continue;
                
                grid[new_row][new_col] = 0;
                q.add(new Pair(new_row, new_col));
            }
        }
    }
}

class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}