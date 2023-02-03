//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]matrix, int R, int C){
        int[] row_arr = {-1,0,1,0}, col_arr={0,1,0,-1};
        int r=0, c=0, dir = 1;
        
        while(r>=0&&r<R && c>=0&&c<C){
            if(matrix[r][c] == 1){
                matrix[r][c] = 0;
                dir++;
            }
            
            r += row_arr[dir%4];
            c += col_arr[dir%4];
        }
        
        r -= row_arr[dir%4];
        c -= col_arr[dir%4];
        
        return new int[]{r,c};
    }
}