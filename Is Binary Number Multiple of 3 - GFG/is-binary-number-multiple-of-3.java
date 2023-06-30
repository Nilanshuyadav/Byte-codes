//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isDivisible(String s) {
        int i,odd=0,eve=0,n=s.length();
	    for(i=0;i<n;i++){
	        if(s.charAt(i)=='1'){
	            if(i%2 != 0)odd++;
	            else eve++;
	        }
	    }
	    return (odd-eve)%3==0 ? 1 : 0;
    }
}