//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {
        // code here
        Arrays.sort(A);
        int min_diff=Integer.MAX_VALUE, ans=-1, i, j, toFind, min, max, sum;
        for(int ind=0; ind<N-2; ind++){
            i=ind+1;
            j=N-1;
            
            toFind = X-A[ind];
            min = (int)1e8;
            max = (int)(-1e8);
            
            while(i<j){
                sum = A[i]+A[j];
                
                if(sum == toFind)   return X;
                else if(sum < toFind){
                    i++;
                    max = Math.max(max, sum);
                }
                else{
                    j--;
                    min = Math.min(min, sum);
                }
                
            }
            
            if(min_diff > toFind-max){
                min_diff = toFind-max;
                ans = X-(toFind-max);
            }
            
            if(min_diff > min-toFind){
                min_diff = min-toFind;
                ans = X+(min-toFind);
            }
        }
        
        return ans;
    }
}