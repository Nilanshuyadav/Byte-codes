//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        int r1=0, r2=R-1, c1=0, c2=C-1;
        
        int[] ans = new int[R*C];
        int k=(R*C)-1;
        
        while(r1<=r2 && c1<=c2){
            int ind=c1;
            
            while(ind<c2){
                ans[k--] = a[r1][ind++];
            }
            
            ind = r1;
            while(ind<r2){
                ans[k--] = a[ind++][c2];
            }
            
            if(r1==r2 || c1==c2){
                ans[k--] = a[r2][c2];
                break;
            }    
            
            ind=c2;
            while(ind>c1){
                ans[k--] = a[r2][ind--];
            }
            
            ind=r2;
            while(ind>r1){
                ans[k--] = a[ind--][c1];
            }
            
            r1++;
            r2--;
            
            c1++;
            c2--;
        }
        
        return ans;
    }
}