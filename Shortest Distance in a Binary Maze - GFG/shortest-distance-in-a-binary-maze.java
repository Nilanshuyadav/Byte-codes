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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0]==destination[0] && source[1]==destination[1])
            return 0;
            
        int row = grid.length, col = grid[0].length;    
            
        Queue<int[]> q = new LinkedList<>();
        q.add(source);
        grid[source[0]][source[1]] = 0;
        int cnt=0;
        
        int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
        
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            
            while(size-->0){
                int[] temp = q.remove();
                
                int r = temp[0];
                int c = temp[1];
                
                for(int ind=0; ind<4; ind++){
                    int new_row = r+r_arr[ind];
                    int new_col = c+c_arr[ind];
                    
                    if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]==0)
                        continue;
                        
                    if(destination[0]==new_row && destination[1]==new_col)
                        return cnt;
                    
                    grid[new_row][new_col] = 0;
                    q.add(new int[]{new_row, new_col});
                }
            }
        }
        
        return -1;
    }
}
