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
    static long ans;
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        ans = 0;
        
        mergeSort(0, (int)N-1, arr);
        
        return ans;
    }
    
    static void mergeSort(int l, int h, long[] arr){
        if(l<h){
            int mid = l+(h-l)/2;
            
            mergeSort(l, mid, arr);
            mergeSort(mid+1, h, arr);
            
            merge(l, mid, h, arr);
        }
    }
    
    static void merge(int l, int mid, int h, long[] arr){
        int i=l, j=mid+1, k=0, n=h-l+1;
        long[] temp_arr = new long[n];
        
        while(i<=mid && j<=h){
            if(arr[i] <= arr[j]){
                temp_arr[k++] = arr[i++];
            }
            else{
                ans += (mid-i+1);
                temp_arr[k++] = arr[j++];
            }
        }
        
        while(i<=mid){
            temp_arr[k++] = arr[i++];
        }
        
        while(j<=h){
            temp_arr[k++] = arr[j++];
        }
        
        for(int ind=l; ind<=h; ind++){
            arr[ind] = temp_arr[ind-l];
        }
    } 
}