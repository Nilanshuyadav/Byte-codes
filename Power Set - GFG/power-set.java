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
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> a.compareTo(b));
        
        solve(0, s, new StringBuilder(""), pq);
        
        List<String> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        
        return ans;
    }
    
    public void solve(int ind, String s, StringBuilder sb, PriorityQueue<String> pq){
        if(ind == s.length()){
            if(sb.length()>0)  pq.add(sb.toString());
            return;
        }
        
        sb.append(s.charAt(ind));
        solve(ind+1, s, sb, pq);
        
        sb.deleteCharAt(sb.length()-1);
        solve(ind+1, s, sb, pq);
        
    }
}