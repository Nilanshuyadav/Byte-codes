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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int row=matrix.length, col=matrix[0].length;
        int cnt=0, temp, new_r, new_c;
        int[] r_arr={-1,-1,0,1,1,1,0,-1}, c_arr={0,1,1,1,0,-1,-1,-1};
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(matrix[r][c] == 1){
                    temp=0;
                    
                    for(int ind=0; ind<8; ind++){
                        new_r = r+r_arr[ind];
                        new_c = c+c_arr[ind];
                        
                        if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || matrix[new_r][new_c]==1)
                            continue;
                            
                        temp++;    
                    }
                    
                    if(temp>0 && (temp&1) == 0) cnt++;
                }
            }
        }
        
        return cnt;
    }
}