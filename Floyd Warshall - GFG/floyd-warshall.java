//{ Driver Code Starts
//Initial template for JAVA

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int row = matrix.length, col = matrix[0].length;
        int max = (int)1e8;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(matrix[r][c] == -1)
                    matrix[r][c] = max;
            }
        }
        
        for(int via=0; via<row; via++){
            for(int r=0; r<row; r++){
                for(int c=0; c<col; c++){
                    int temp = Math.min(max, matrix[r][via] + matrix[via][c]);
                    matrix[r][c] = Math.min(matrix[r][c], temp);
                }
            }
        }
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(matrix[r][c] == max)
                    matrix[r][c] = -1;
            }
        }
    }
}