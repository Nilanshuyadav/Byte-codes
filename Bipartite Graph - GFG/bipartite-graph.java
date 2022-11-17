//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Boolean[] vis = new Boolean[V];
        
        for(int ind=0; ind<V; ind++){
            
            if(vis[ind] == null && !dfs(ind, adj, vis, true))
                return false;
        }
        
        return true;
    }
    
    public boolean dfs(int ind, ArrayList<ArrayList<Integer>> adj, Boolean[] vis, boolean type){
        vis[ind] = type;
        
        for(int inx : adj.get(ind)){
            if(vis[inx] != null){
                if(vis[inx] == type)
                    return false;
                else
                    continue;
            }
            
            if(!dfs(inx, adj, vis, !type))
                return false;
        }
        
        return true;
    }
}
