//{ Driver Code Starts
// Initial Template for Java

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
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V+1];
        int cnt=0, temp[];
        
        for(int ind=1; ind<=V; ind++){
            if(!vis[ind]){
                temp = dfs(ind, vis, adj);
                
                if(temp[1] == ((temp[0] * (temp[0]-1))/2))
                    cnt++;
            }
        }
        
        return cnt;
    }
    
    public int[] dfs(int ind, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        int node=1, edge=0;
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(ind);
        int temp;
        vis[ind] = true;
        
        while(!q.isEmpty()){
            temp = q.remove();
            
            for(int i : adj.get(temp)){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                    node++;
                }
                edge++;
            }
        }
        
        return new int[]{node, edge/2};
    }
}