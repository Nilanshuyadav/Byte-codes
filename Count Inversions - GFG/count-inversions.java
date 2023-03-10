//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long cnt;
    static long inversionCount(long arr[], long N)
    {
        cnt=0;
        mergeBreak(0, (int)N-1, arr);
        
        return cnt;
    }
    
    static void mergeBreak(int l, int h, long[] arr){
        if(l<h){
            int m = l+(h-l)/2;
            
            mergeBreak(l, m, arr);
            mergeBreak(m+1, h, arr);
            
            merge(l, m, h, arr);
        }
    }
    
    static void merge(int l, int m, int h, long[] arr){
        int size = h-l+1;
        long[] temp_arr = new long[size];
        
        int i=l, j=m+1;
        int k=0;
        
        while(i<=m && j<=h){
            if(arr[i] <= arr[j]){
                temp_arr[k++] = arr[i++];
            }
            else{
                cnt += m-i+1;
                temp_arr[k++] = arr[j++];
            }
        }    
        
        while(i<=m){
            temp_arr[k++] = arr[i++];
        }
        
        while(j<=h){
            temp_arr[k++] = arr[j++];
        }
        
        for(int ind=0; ind<size; ind++){
            arr[ind+l] = temp_arr[ind];
        }
    }
}