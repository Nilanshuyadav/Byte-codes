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
    static char[][] fill(int n, int m, char a[][])
    {
        int row = a.length;
        int col = a[0].length;
        
        for(int ind=0; ind<row; ind++){
            if(a[ind][0] == 'O')
                dfs(ind, 0, a);
            if(a[ind][col-1] == 'O')
                dfs(ind, col-1, a);
        }
        
        for(int ind=0; ind<col; ind++){
            if(a[0][ind] == 'O')
                dfs(0, ind, a);
            if(a[row-1][ind] == 'O')
                dfs(row-1, ind, a);
        }
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(a[r][c] == 'O')
                    a[r][c] = 'X';
                else if(a[r][c] == '*')
                    a[r][c] = 'O';
            }
        }
        
        return a;
    }
    
    public static void dfs(int r, int c, char[][] a){
        int row = a.length;
        int col = a[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
        
        q.add(new Pair(r,c));
        a[r][c] = '*';
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int ind=0; ind<4; ind++){
                int new_row = temp.row+r_arr[ind];
                int new_col = temp.col+c_arr[ind];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || a[new_row][new_col]!='O')
                    continue;
                    
                a[new_row][new_col] = '*';
                q.add(new Pair(new_row, new_col));
            }
        }
    }
}

class Pair{
    int row; 
    int col;
    public Pair(int row, int col){
        this.row =  row;
        this.col = col;
    }
}