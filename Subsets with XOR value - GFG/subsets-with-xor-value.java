//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int subsetXOR(int arr[], int N, int K) {
        // code here
        int[][] dp = new int[N][128];
        
        for(int ind=0; ind<128; ind++){
            if((ind^arr[0])==K || ind==K){
                dp[0][ind] = 1;
            }
        }
        
        for(int i=1; i<N; i++){
            for(int j=0; j<128; j++){
                dp[i][j] = dp[i-1][j]+dp[i-1][j^arr[i]];
            }
        }
        
        return dp[N-1][0];
    }
    
    // static int solve(int ind, int[] arr, int xor, int K){
    //     if(ind == 0){
    //         return (xor^arr[0])==K || xor==K ? 1:0;
    //     }
        
    //     return solve(ind-1, arr, xor, K) + solve(ind-1, arr, xor^arr[ind], K);
    // }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] =s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.subsetXOR(arr,N,K));
        }
    }
}
// } Driver Code Ends