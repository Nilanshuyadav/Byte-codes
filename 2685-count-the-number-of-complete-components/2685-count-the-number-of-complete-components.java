class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++){
            adj.add(new ArrayList<>());
        }
        
        for(int ind[] : edges){
            adj.get(ind[1]).add(ind[0]);
            adj.get(ind[0]).add(ind[1]);
        }
        
        boolean[] vis = new boolean[n];
        
        int cnt=0, nodes, edge,  temp[];
        
        for(int ind=0; ind<n; ind++){
            if(!vis[ind]){
                temp = solve(ind, adj, new HashSet<>(), vis);
                
                nodes = temp[0];
                edge = temp[1];
                
                if(edge == ((nodes)*(nodes-1))/2){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public int[] solve(int ind, List<List<Integer>> adj, Set<String> set, boolean[] vis){
        vis[ind] = true;
        int temp[], nodes = 1;
        String st;
        
        for(int inx : adj.get(ind)){
            if(!vis[inx]){
                temp = solve(inx, adj, set, vis);
                
                nodes += temp[0];
            }
            
            st = ""+Math.min(ind, inx)+","+Math.max(ind, inx);
            
            set.add(st);
        }
        
        return new int[]{nodes, set.size()};
    }
}