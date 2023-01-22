//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        
        for(int ind : arr)
            sum += ind;
            
        if(sum%2!=0)
            return 0;
            
        return solve(N-1, 0, arr, sum/2)? 1 : 0;
            
    }
    
    static boolean solve(int ind, int sum, int[] arr, int to_find){
        if(ind==-1 || sum>to_find)
            return sum==to_find;
        
        return solve(ind-1, sum+arr[ind], arr, to_find) || solve(ind-1, sum, arr, to_find);
    }
}