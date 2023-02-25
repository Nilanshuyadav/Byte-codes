//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String A, String B)
    {
        int i=A.length()-1, j=B.length()-1;
        
        int[] arr = new int[58];
        for(int ind=0; ind<=i; ind++)
            arr[A.charAt(ind)-'A']++;
        for(int ind=0; ind<=j; ind++)
            arr[B.charAt(ind)-'A']--;
            
        for(int ind=0; ind<58; ind++)
            if(arr[ind]!=0)
                return -1;
           
        int cnt=0;   
        while(i>=0 && j>=0){
            if(A.charAt(i) == B.charAt(j)){
                j--;
            }
            else{
                cnt++;
            }
            i--;
        }
        
        return cnt;
    }
}