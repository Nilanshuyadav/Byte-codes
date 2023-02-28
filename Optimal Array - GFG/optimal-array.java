//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long arr[]=ob.optimalArray(n,a);
            for(long i:arr){
                out.print(i+" ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    public long[] optimalArray(int n,int a[])
    {
        int k=1;
        long[] arr = new long[n];
        
        for(int ind=1; ind<n; ind++){
            arr[k++] = findMin(0, ind, a, arr);
        }
        
        return arr;
    }
    
    public long findMin(int l, int h, int[] a, long[] arr){
        
        int m = l+(h-l)/2;
        
        return arr[h-1] + Math.abs(a[h] - a[m]);
    }
}
        
