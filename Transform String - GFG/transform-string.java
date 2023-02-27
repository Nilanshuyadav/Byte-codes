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
        int i=A.length()-1, j=B.length()-1, cnt=0;
        
        if(notPossible(i, j, A, B))
            return -1;
        
        while(i>=0){
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
    
    public boolean notPossible(int i, int j, String A, String B){
        if(i != j)  return true;
        
        int[] fre = new int[58];
        
        for(int ind=0; ind<=i; ind++){
            fre[A.charAt(ind) - 'A']++;
            fre[B.charAt(ind) - 'A']--;
        }
        
        for(int ind=0; ind<58; ind++)
            if(fre[ind] != 0)
                return true;
                
        return false;        
    }
}