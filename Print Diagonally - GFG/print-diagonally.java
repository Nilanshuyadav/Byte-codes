//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        int row = A.length, col = A[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int ind=0; ind<col; ind++){
            int temp_row = 0, temp_col=ind;
            
            while(temp_row<row && temp_col>=0){
                ans.add(A[temp_row++][temp_col--]);
            }
        }
        
        for(int ind=1; ind<row; ind++){
            int temp_row = ind, temp_col=col-1;
            
            while(temp_row<row && temp_col>=0){
                ans.add(A[temp_row++][temp_col--]);
            }
        }
        
        return ans;
    }
}
