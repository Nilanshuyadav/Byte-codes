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
        int row = grid.length, col = grid[0].length;
        int cnt=0;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == '1'){
                    cnt++;
                    solve(r, c, grid);
                }    
            }
        }
        
        return cnt;
    }
    
    public void solve(int r, int c, char[][] grid){
        int row = grid.length, col = grid[0].length;
        
        int[] r_arr = {-1,-1,0,1,1,1,0,-1}, c_arr = {0,1,1,1,0,-1,-1,-1};
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{r,c});
        grid[r][c] = '0';
        
        int new_r, new_c, temp[];
        
        while(!q.isEmpty()){
            temp = q.remove();
            
            for(int ind=0; ind<8; ind++){
                new_r = temp[0] + r_arr[ind];
                new_c = temp[1] + c_arr[ind];
                
                if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || grid[new_r][new_c]!='1')   continue;
                
                grid[new_r][new_c] = '0';
                q.add(new int[]{new_r, new_c});
            }
        }
    }
}