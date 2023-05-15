//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int ans;
    public int countRevPairs(int N, int arr[]) {
        // Code here
        ans = 0;
        
        mergeSort(0, N-1, arr);
        return ans;
    }
    
    public void mergeSort(int l, int h, int[] arr){
        if(l<h){
            int mid = l + (h-l)/2;
            
            mergeSort(l, mid, arr);
            mergeSort(mid+1, h, arr);
            
            merge(l, mid, h, arr);
        }
    }
    
    public void merge(int l, int mid, int h, int[] arr){
        int i=l, j=mid+1, n=h-l+1, k=0;
        int[] temp_arr = new int[n];
        
        while(i<=mid && j<=h){
            if(arr[i]<=arr[j]){
                temp_arr[k++] = arr[i++];
            }
            else{
                int pos = findPos((2*arr[j])+1, arr, i, mid);
                if(pos!=mid+1){
                    ans += mid-pos+1;
                }
                
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
    
    public int findPos(int target, int[] arr, int l, int h){
        int m, min=Integer.MAX_VALUE;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(arr[m] == target){
                min = Math.min(min, m);
                h = m-1;
            }
            else if(arr[m] < target){
                l = m +1;
            }
            else{
                h = m-1;
            }
        }
        
        return min==Integer.MAX_VALUE? h+1 : min;
    }
}