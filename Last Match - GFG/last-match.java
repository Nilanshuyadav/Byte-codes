//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static int findLastOccurence(String A,String B){
        int temp = A.lastIndexOf(B);
        return temp==-1? -1 : temp+1;
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
            
            String A = read.readLine().trim();
             String B = read.readLine().trim();
          

            Solution ob = new Solution();
            System.out.println(ob.findLastOccurence(A,B));
        }
    }
}
// } Driver Code Ends