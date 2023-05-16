//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int A[], int a, int b, int key)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        
        
        int n = A.length;
        
        if(A[0] < A[n-1]){
            return findPos(A, 0, n-1, key);
        }
        
        int pivot=-1;
        
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(A[m] > A[m+1]){
                pivot = m;
                break;
            }
            else if(A[m] < A[h]){
                h = m;
            }
            else{
                l = m+1;
            }
        }
        
        int ind1 = findPos(A, 0, pivot, key), ind2 = findPos(A, pivot+1, n-1, key);
        
        return ind1==-1 ? ind2 : ind1;
    }
    
    
    int findPos(int[] A, int l, int h, int key){
        int m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(A[m] == key){
                return m;
            }
            else if(A[m] < key){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return -1;
    }
}