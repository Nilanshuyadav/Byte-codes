class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;

       for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
       } 

        for(int i=0; i<n; i++){         
            for(int j=0; j<graph[i].length; j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        Boolean[] vis = new Boolean[n];

        for(int i=0; i<n; i++){
            helper(i, adj, vis);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(vis[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean helper(int ind, List<List<Integer>> adj, Boolean[] vis){
        if(vis[ind] != null) return vis[ind];

        List<Integer> e = adj.get(ind);
        boolean ans = true;
        vis[ind] = false;

        for(int i : e){
            ans &= helper(i, adj, vis);
        }

        return vis[ind] = ans;
    }
}