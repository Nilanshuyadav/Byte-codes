//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    Set<String> set;
    int countDistinctIslands(int[][] grid) {
        set = new HashSet<>();
        
        int row = grid.length, col = grid[0].length;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 1){
                    grid[r][c] = 0;
                    dfs(r,c, grid);
                }
            }
        }
        
        return set.size();
    }
    
    void dfs(int r, int c, int[][] grid){
        int row = grid.length, col = grid[0].length;
        int[] r_arr = {-1,0,1,0}, c_arr={0,1,0,-1};
        char[] ch_arr = {'U','R','N','L'};
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        
        StringBuilder sb = new StringBuilder("");
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                Pair temp = q.remove();
                
                for(int ind=0; ind<4; ind++){
                    int new_row = temp.row+r_arr[ind];
                    int new_col = temp.col+c_arr[ind];
                    char ch = ch_arr[ind];
                    
                    if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]==0){
                        sb.append('*');
                        continue;
                    }
       
                    sb.append(ch);
                    q.add(new Pair(new_row, new_col));
                    grid[new_row][new_col] = 0;
                }
            }
        }
        
        set.add(sb.toString());
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
