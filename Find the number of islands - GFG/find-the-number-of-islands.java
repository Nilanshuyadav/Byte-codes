//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int ans=0;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == '1'){
                    ans++;
                    dfs(r,c,row,col,grid);
                }
            }
        }
        
        
        return ans;
    }
    
    public void dfs(int r, int c, int row, int col, char[][] grid){
        int[] r_arr = {1,1,0,-1,-1,-1,0,1}, c_arr = {0,1,1,1,0,-1,-1,-1};
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(r,c));
        grid[r][c] = '0';
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int ind=0; ind<8; ind++){
                int new_row = temp.row+r_arr[ind];
                int new_col = temp.col+c_arr[ind];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]=='0')
                    continue;
                    
                grid[new_row][new_col] = '0';
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