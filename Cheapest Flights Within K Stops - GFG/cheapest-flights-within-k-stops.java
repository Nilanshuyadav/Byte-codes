//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++){
            adj.add(new ArrayList<>());
        }
        
        for(int ind[] : flights){
            adj.get(ind[0]).add(new Pair(ind[1], ind[2]));
        }
        
        boolean[] vis = new boolean[n];
        int[][] dp = new int[n][k+2];
        for(int ind[] : dp)
            Arrays.fill(ind, -2);
        
        return dfs(src, dst, k+1, adj, vis, dp);    
    }
    
    public int dfs(int src, int dst, int k, List<List<Pair>> adj, boolean[] vis, int[][] dp){
        
        if(k<0)
            return -1;
        
        if(src == dst)
            return 0;
            
        if(dp[src][k] != -2) return dp[src][k];    
        
        vis[src] = true;
        
        int ans  =Integer.MAX_VALUE;
        
        for(Pair p : adj.get(src)){
            int to = p.to;
            int price = p.price;
            
            if(vis[to])
                continue;
                
            int temp = dfs(to, dst, k-1, adj, vis, dp);
            
            if(temp != -1){
                ans = Math.min(price+temp, ans);
            }
        }
        
        vis[src] = false;
        
        if(ans == Integer.MAX_VALUE)
            return dp[src][k] = -1;
        return dp[src][k] = ans;    
    }
}

class Pair{
    int to;
    int price;
    public Pair(int to, int price){
        this.to = to;
        this.price = price;
    }
}