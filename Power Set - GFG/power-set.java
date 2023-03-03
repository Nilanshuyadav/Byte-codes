//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        int number = (1<<n) - 1, k=n;
        
        StringBuilder sb = new StringBuilder("");
        int num=0;
        
        for(int ind=1; ind<=number; ind++){
            while(k-->0){
                if((ind&(1<<num)) > 0){
                    sb.insert(0, s.charAt(n-num-1));
                }
                
                num++;
            }
            
            ans.add(sb.toString());
            num = 0;
            k = n;
            sb.setLength(0);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}