//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
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
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        int[] toSort = new int[n];
        long[] pre = new long[n];
       
        for(int ind=0; ind<n; ind++){
            toSort[ind] = arr[ind];
        }
        
        Arrays.sort(toSort);
        
        for(int ind=1; ind<n; ind++){
            pre[ind] = pre[ind-1]+toSort[ind-1];
        }
        
        long[] ans = new long[n];
        
        int index;
        for(int ind=0; ind<n; ind++){
            index = findPos(toSort, arr[ind]);
            
            ans[ind] = pre[index];
        }
        
        return ans;
    }
    
    public int findPos(int[] arr, int target){
        int l=0, h=arr.length-1, m, min=Integer.MAX_VALUE;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(arr[m] == target){
                min = Math.min(min, m);
                h = m-1;
            }
            else if(arr[m] < target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return min;
    }
}