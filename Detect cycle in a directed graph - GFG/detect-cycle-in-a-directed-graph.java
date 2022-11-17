//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis, dfs_vis;
        vis = new boolean[V];
        dfs_vis = new boolean[V];
        
        for(int ind=0; ind<V; ind++){
            if(!vis[ind] && dfs(ind, vis, dfs_vis, adj)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int ind, boolean[] vis, boolean[] dfs_vis, ArrayList<ArrayList<Integer>> adj){
        vis[ind] = true;
        dfs_vis[ind] = true;
        
        for(int inx : adj.get(ind)){
            if(dfs_vis[inx])
                return true;
            else if(vis[inx])
                continue;
            if(dfs(inx, vis, dfs_vis, adj))
                return true;
        }
        
        dfs_vis[ind] = false;
        
        return false;
    }
}