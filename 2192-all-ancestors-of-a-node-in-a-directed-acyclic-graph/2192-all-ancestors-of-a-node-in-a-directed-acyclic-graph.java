class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(), ans = new ArrayList<>();;

        for(int ind=0; ind<n; ind++){
            adj.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }

        for(int ind[] : edges){
            adj.get(ind[0]).add(ind[1]);
        }    

        for(int ind=0; ind<n; ind++){
            boolean vis[] = new boolean[n];
            dfs(ind, ind, adj, ans, vis);
        }

        return ans;
    }


    public void dfs(int ind, int toAdd, List<List<Integer>> adj, List<List<Integer>> ans, boolean[] vis){
        for(int inx : adj.get(ind)){
            if(vis[inx])
                continue;
            vis[inx] = true;    
            ans.get(inx).add(toAdd);
            dfs(inx, toAdd, adj, ans, vis);
        }
    }
}