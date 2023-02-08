//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        int count_negative=0, first_negative=-1, start=0;
        int max = 0;
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind] == 0){
                start=ind+1;
                first_negative = -1;
                count_negative = 0;
                continue;
            }
            else if(arr[ind]<0){
                count_negative++;
                if(first_negative==-1)
                    first_negative = ind;
            }
            
            if(count_negative%2==0){
                max = Math.max(max, ind-start+1);
            }
            else{
                max = Math.max(max, ind-first_negative);
            }
        }
        
        return max;
    }
   
}