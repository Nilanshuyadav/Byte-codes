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
        Queue<int[]> q = new LinkedList<>();
        
        char[][] ans = new char[n][m];
        
        for(int r=0; r<n; r++){
            if(a[r][0] == 'O'){
                q.add(new int[]{r,0});
                ans[r][0] = 'O';
            }
            
            if(a[r][m-1] == 'O'){
                q.add(new int[]{r, m-1});
                ans[r][m-1] = 'O';
            }
        }
        
        for(int c=1; c<m-1; c++){
            if(a[0][c] == 'O'){
                q.add(new int[]{0, c});
                ans[0][c] = 'O';
            }
            
            if(a[n-1][c] == 'O'){
                q.add(new int[]{n-1, c});
                ans[n-1][c] = 'O';
            }
        }
        
        int temp[], new_r, new_c, r_arr[]={-1,0,1,0}, c_arr[]={0,1,0,-1};
        
        while(!q.isEmpty()){
            temp = q.remove();
            
            ans[temp[0]][temp[1]] = 'O';
            
            for(int ind=0; ind<4; ind++){
                new_r = temp[0] + r_arr[ind];
                new_c = temp[1] + c_arr[ind];
                
                if(new_r<0 || new_c<0 || new_r>=n || new_c>=m || a[new_r][new_c]!='O' || ans[new_r][new_c]=='O')  continue;
                
                ans[new_r][new_c] = 'O';
                q.add(new int[]{new_r, new_c});
            }
        }
        
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(ans[r][c] != 'O')
                    ans[r][c] = 'X';
            }
        }
        
        return ans;
    }
}