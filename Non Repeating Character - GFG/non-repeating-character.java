//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        int n = S.length();
        int[] arr = new int[26];
        
        for(int ind=0; ind<n; ind++){
            arr[S.charAt(ind)-'a']++;
        }
        
        for(int ind=0; ind<n; ind++){
            if(arr[S.charAt(ind)-'a'] == 1){
                return S.charAt(ind);
            }
        }
        
        return '$';
    }
}

