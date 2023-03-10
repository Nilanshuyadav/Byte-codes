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
        int m1 = (m+n-1)/2, m2 = (m+n)/2;
        
        int i=0, j=0, k=-1;
        int num1=-1, num2=-1;
        
        while(i<n && j<m){
            if(a[i] < b[j]){
                i++;
                k++;
                
                if(k==m1){
                    num1 = a[i-1];
                }
                if(k==m2){
                    num2 = a[i-1];
                }
            }
            else{
                j++;
                k++;
                
                if(k==m1){
                    num1 = b[j-1];
                }
                if(k==m2){
                    num2 = b[j-1];
                }
            }
            
            if(num1!=-1 && num2!=-1)
                break;
        }
        
        while(i<n){
            i++;
            k++;
            
            if(k==m1){
                num1 = a[i-1];
            }
            if(k==m2){
                num2 = a[i-1];
            }
        }
        
        while(j<m){
            j++;
            k++;
            
            if(k==m1){
                num1 = b[j-1];
            }
            if(k==m2){
                num2 = b[j-1];
            }
        }
        
        return ((double)(num1+num2))/2;
    }
}