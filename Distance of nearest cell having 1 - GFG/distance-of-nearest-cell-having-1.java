//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int row = grid.length, col = grid[0].length;
        
        int[][] ans = new int[row][col];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 1){
                    q.add(new Pair(r,c));
                }
            }
        }
        
        int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
        
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair temp = q.remove();
                
                for(int ind=0; ind<4; ind++){
                    int new_row = temp.row+r_arr[ind];
                    int new_col = temp.col+c_arr[ind];
                    
                    if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]==1 || ans[new_row][new_col]!=0)
                        continue;
                    
                    ans[new_row][new_col] = ans[temp.row][temp.col]+1;
                    q.add(new Pair(new_row, new_col));
                }
            }
        }
        
        return ans;
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