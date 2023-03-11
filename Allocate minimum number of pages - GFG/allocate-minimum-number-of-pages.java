//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(M>N) return -1;
        
        int total = 0, max=Integer.MIN_VALUE;
        for(int ind : A){
            total += ind;
            max = Math.max(max, ind);
        }
        
        
        int l=max, h=total+1, ans=-1, m, cnt;
        
        while(l<h){
            m = l + (h-l)/2;
            
            cnt = check(A, N, m, M);
            
            if(cnt <= M){
                h=m;
            }
            else l=m+1;
        }
        
        return h==total+1 ? -1 : h;
    }
    
    public static int check(int[] A, int N, int m, int M){
        int cnt=0;
        long sum=0;
        
        for(int ind=0; ind<N; ind++){
            
            if(sum+A[ind] > m){
                cnt++;
                sum=0;
            }
            
            sum += A[ind];
        }
        cnt++;
        
        return cnt;
    }
};