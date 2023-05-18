//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[] r_arr={-1, 0, 1, 0}, c_arr={0, 1, 0, -1};
    
    public int closedIslands(int[][] matrix, int N, int M)
    {
        int row = N, col = M;
        int cnt=0;
        
        for(int ind=0; ind<row; ind++){
            if(matrix[ind][0] == 1){
                makeZero(ind, 0, matrix);
            }
            
            if(matrix[ind][col-1] == 1){
                makeZero(ind, col-1, matrix);
            }
        }
        
        for(int ind=0; ind<col; ind++){
            if(matrix[0][ind] == 1){
                makeZero(0, ind, matrix);
            }
            
            if(matrix[row-1][ind] == 1){
                makeZero(row-1, ind, matrix);
            }
        }
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(matrix[r][c] == 1){
                    cnt++;
                    makeZero(r, c, matrix);
                }
            }
        }
        
        return cnt;
    }
    
    public void makeZero(int r, int c, int[][] matrix){
        matrix[r][c] = 0;
        
        int new_r, new_c, row=matrix.length, col=matrix[0].length;
        
        for(int ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=row ||  new_c>=col || matrix[new_r][new_c]!=1)  continue;
            
            makeZero(new_r, new_c, matrix);
        }
    }
}