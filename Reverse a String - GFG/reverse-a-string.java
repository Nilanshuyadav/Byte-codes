// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        char[] st = str.toCharArray();
        
        
        int n = st.length;
        int left = 0,right = n-1;
        
        while(left < right){
            char ch = st[left];
            st[left] = st[right];
            st[right] = ch;
            left++;
            right--;
            
        }
        
        return String.valueOf(st);
    }
}