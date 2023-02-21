//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String s)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int k=0, temp;
        
        while(true){
            temp = s.indexOf(pat);
            
            if(temp == -1)
                break;
            ans.add(temp+1+k);
            s = s.substring(temp+1);
            k += temp+1;
        }
        
        if(ans.size()==0)
            ans.add(-1);
        
        return ans;
    }
}