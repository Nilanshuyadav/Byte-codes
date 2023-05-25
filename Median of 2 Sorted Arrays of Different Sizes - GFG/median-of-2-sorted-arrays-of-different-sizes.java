//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        int sum = n+m, median, n1, n2, i=0, j=0, ans;
        double total=0;
        
        if((sum&1) != 0){
            median = sum/2;
            
            while(i<n && j<m){
                if(a[i] < b[j]){
                    ans = a[i++];
                }
                else{
                    ans = b[j++];
                }
                
                if(median-- == 0){
                    return ans;
                }
            }
            
            while(i<n){
                ans = a[i++];
                
                if(median-- == 0){
                    return ans;
                }
            }
            
            while(j<m){
                ans = b[j++];
                
                if(median-- == 0){
                    return ans;
                }
            }
        }
        else{
            n1 = sum/2;
            n2 = sum/2 - 1;
            
            while(i<n && j<m){
                if(a[i] < b[j]){
                    ans = a[i++];
                }
                else{
                    ans = b[j++];
                }
                
                if(n1-- == 0){
                    total += ans;
                }
                if(n2-- == 0){
                    total += ans;
                }
                
                if(n1<0 && n2<0){
                    return total/2;
                }
            }
            
            while(i<n){
                ans = a[i++];
                
                if(n1-- == 0){
                    total += ans;
                }
                if(n2-- == 0){
                    total += ans;
                }
                
                if(n1<0 && n2<0){
                    return total/2;
                }
            }
            
            while(j<m){
                ans = b[j++];
                
                if(n1-- == 0){
                    total += ans;
                }
                if(n2-- == 0){
                    total += ans;
                }
                
                if(n1<0 && n2<0){
                    return total/2;
                }
            }
        }
        
        return -1;
    }
}