//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        int pre_orange = -1, orange_count=0;
        int max = 0;
        
        for(int ind=0; ind<n; ind++){
            if(arr.charAt(ind)=='O'){
                if(orange_count<m){
                    orange_count++;
                }
                else{
                    while(arr.charAt(++pre_orange) != 'O');
                }
            }
            
            max = Math.max(ind-pre_orange, max);
        }
        
        return max;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends