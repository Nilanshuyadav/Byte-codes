//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        
        boolean[] vis = new boolean[V], ans = new boolean[V];
        
        for(int ind=0; ind<V; ind++){
            if(!vis[ind]){
                dfs(ind, adj, ans, vis);
            }
        }
        
        for(int ind=0; ind<V; ind++)
            if(ans[ind])
                result.add(ind);
        
        return result;
    }
    
    public boolean dfs(int ind, List<List<Integer>> adj, boolean[] ans, boolean[] vis){
        vis[ind] = true;
        ans[ind] = false;
        
        for(int inx : adj.get(ind)){
            if(vis[inx]){
                if(!ans[inx])
                    return ans[ind] = ans[inx];
                else
                    continue;
            }
                
            if(!dfs(inx, adj, ans, vis))
                return ans[ind] = false;    
        }
        
        return ans[ind] = true;
    }
}
