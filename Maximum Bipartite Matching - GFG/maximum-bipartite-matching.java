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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    boolean[] vis;
    int[] matched_pair;
    public int maximumMatch(int[][] G)
    {
        int applicants = G.length, jobs = G[0].length;
        
        matched_pair = new int[jobs];
        Arrays.fill(matched_pair, -1);
        
        int cnt=0;
        
        for(int ind=0; ind<applicants; ind++){
            vis = new boolean[jobs];
            
            if(solve(ind, G))
                cnt++;
        }
        
        return cnt;
    }
    
    public boolean solve(int person, int[][] G){
        for(int job=0; job<G[0].length; job++){
            
            if(G[person][job]==1 && !vis[job]){
                vis[job] = true;
                
                if(matched_pair[job]==-1 || solve(matched_pair[job], G)){
                    matched_pair[job] = person;
                    return true;
                }
            }
        }
        
        return false;
    }
}