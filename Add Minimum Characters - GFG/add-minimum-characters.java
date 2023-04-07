//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		int n = str.length();
		int min = Integer.MAX_VALUE;
		
		for(int ind=0; ind<=n/2; ind++){
		    min = Math.min(min, Math.min(findMin(ind, ind+1, str, n), findMin(ind, ind, str, n)));
		}
		
		return min;
	}
	
	public static int findMin(int s, int e, String str, int n){
	    while(s>=0 && e<n){
	        if(str.charAt(s) != str.charAt(e))
	            return Integer.MAX_VALUE;
	        
	        s--;
	        e++;
	        
	        if(s>=0 && e>=n)    return Integer.MAX_VALUE;
	    }
	    
	    return n-e;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends