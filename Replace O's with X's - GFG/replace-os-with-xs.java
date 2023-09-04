//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[] r_arr={-1, 0, 1, 0}, c_arr={0, 1, 0, -1};
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        for(int r=0; r<n; r++){
            if(a[r][0] == 'O') solve(r, 0, a, n, m);
            if(a[r][m-1] == 'O') solve(r, m-1, a, n, m);
        }
        
        for(int c=0; c<m; c++){
            if(a[0][c] == 'O') solve(0, c, a, n, m);
            if(a[n-1][c] == 'O') solve(n-1, c, a, n, m);
        }
        
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(a[r][c] == 'O'){
                    a[r][c] = 'X';
                }
                else if(a[r][c] == '*'){
                    a[r][c] = 'O';
                }
            }
        }
        
        return a;
    }
    
    static void solve(int r, int c, char a[][], int row, int col){
        a[r][c] = '*';
        
        int new_r, new_c;
        
        for(int ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || a[new_r][new_c]!='O') continue;
            solve(new_r, new_c, a, row, col);
        }
    }
}