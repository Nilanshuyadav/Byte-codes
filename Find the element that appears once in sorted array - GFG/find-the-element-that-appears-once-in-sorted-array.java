//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        if(n == 1){
            return arr[0];
        }
        else if(arr[0]!=arr[1]){
            return arr[0];
        }
        else if(arr[n-1]!=arr[n-2]){
            return arr[n-1];
        }
        
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if((((m&1)!=0) && arr[m]==arr[m-1]) || (((m&1)==0) && arr[m]==arr[m+1])){
                l = m+1;
            } 
            else{
                h = m-1;
            }
        }
        
        return arr[l];
    }
}