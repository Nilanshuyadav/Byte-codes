//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Queue<Pair> q = new LinkedList<>();
        
        for(int ind=0; ind<V; ind++){
            if(!vis[ind]){
                vis[ind] = true;
                q.add(new Pair(ind, -1));
                
                while(!q.isEmpty()){
                    Pair temp = q.remove();
                    
                    for(int inx : adj.get(temp.ind)){
                        if(inx == temp.parent)
                            continue;
                        
                        if(vis[inx]){
                            return true;
                        }
                        vis[inx] = true;
                        q.add(new Pair(inx, temp.ind));
                    }
                }
            }
        }
        
        return false;
    }
}

class Pair{
    int ind;
    int parent;
    public Pair(int ind, int parent){
        this.ind = ind;
        this.parent = parent;
    }
}