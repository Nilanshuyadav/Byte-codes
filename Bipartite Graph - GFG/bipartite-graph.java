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
            
            if(vis[ind] == null && !dfs(ind, adj, vis))
                return false;
        }
        
        return true;
    }
    
    public boolean dfs(int ind, ArrayList<ArrayList<Integer>> adj, Boolean[] vis){
        vis[ind] = true;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(ind, true));
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                Pair temp = q.remove();
                
                for(int inx : adj.get(temp.ind)){
                    if(vis[inx] != null){
                        if(vis[inx] == temp.type)
                            return false;
                        else
                            continue;
                    }
                    vis[inx] = !temp.type;
                    q.add(new Pair(inx, vis[inx]));
                }
            }
        }
        
        return true;
    }
}

class Pair{
    int ind;
    boolean type;
    public Pair(int ind, boolean type){
        this.ind = ind;
        this.type = type;
    }
}