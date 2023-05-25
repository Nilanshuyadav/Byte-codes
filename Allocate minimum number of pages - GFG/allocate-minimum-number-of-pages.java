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
        //Your code here
        if(M > N){
            return -1;
        }
        
        int total = 0, max=-1;
        
        for(int ind : A){
            total += ind;
            max = Math.max(max, ind);
        }
        
        int l=max, h=total, m, ans=Integer.MAX_VALUE, temp;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            temp = canWe(m, A);
            
            if(temp<=M){
                ans = Math.min(ans, m);
                h = m-1;
            }
            // else if(temp<M){
            //     h = m-1;
            // }
            else{
                l = m+1;
            }
        }
        
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    
    public static int canWe(int m, int[] A){
        int cnt=0, sum = 0;
        
        for(int ind : A){
            sum += ind;
            
            if(m<sum){
                cnt++;
                sum = ind;
            }
        }
        
        return cnt+1;
    }
};