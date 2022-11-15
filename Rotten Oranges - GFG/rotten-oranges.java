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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        Queue<Pair> q = new LinkedList<>();
        
        int row = grid.length;
        int col = grid[0].length;
        
        boolean one = false, bool;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 2)
                    q.add(new Pair(r,c));
                else if(grid[r][c] == 1)
                    one = true;
            }
        }
        
        
        if(q.size()==0 && one) return -1;
        if(!one) return 0;
        
        int[] r={-1,0,1,0}, c={0,1,0,-1};
        
        int ans=0;
        
        while(true){
            int size = q.size();
            
            while(size-->0){
                Pair temp = q.remove();
                
                for(int ind=0; ind<4; ind++){
                    int new_row = temp.row+r[ind];
                    int new_col = temp.col+c[ind];
                    
                    if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]!=1)
                        continue;
                        
                    grid[new_row][new_col] = 2;
                    q.add(new Pair(new_row, new_col));
                }
            }
            
            bool = q.isEmpty();
            if(!bool){
                ans++;
            }
            else
                break;
        }
        
        for(int ro=0; ro<row; ro++){
            for(int co=0; co<col; co++){
                if(grid[ro][co] == 1)
                    return -1;
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