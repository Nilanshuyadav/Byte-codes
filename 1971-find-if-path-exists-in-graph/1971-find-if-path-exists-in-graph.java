class Solution {
    public boolean validPath(int n, int[][] edges, int source, int d) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        
        if(source ==  d) return true;
        
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i[] : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            for(int i : adj.get(temp)){
                if(i == d) return true;
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
            }    
        }
        return false;
    }
}