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
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int nums[], int n)
    {
        //complete the function here
        if(nums[0] < nums[n-1]){
            return nums[0];
        }
        
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(nums[m]>nums[m+1]){
                return nums[m+1];
            }
            else if(nums[m] < nums[h]){
                h = m;
            }
            else{
                l = m+1;
            }
        }
        
        return -1;
    }
}
