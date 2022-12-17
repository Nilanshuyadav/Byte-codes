class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] reach_time = new int[n], min_time = new int[n];
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(List<Integer> ind : connections){
            adj.get(ind.get(0)).add(ind.get(1));
            adj.get(ind.get(1)).add(ind.get(0));
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++){
            dfs(1, ind, reach_time, min_time, ans, adj, -1);
        }
        
        return ans;
    }
    
    public int dfs(int time, int ind, int[] reach_time, int[] min_time, List<List<Integer>> ans, List<List<Integer>> adj, int parent){
        if(reach_time[ind] != 0)
            return min_time[ind];
        
        reach_time[ind] = time;
        min_time[ind] = time;
        
        for(int inx : adj.get(ind)){
            if(inx == parent)
                continue;
        
            int temp = dfs(time+1, inx, reach_time, min_time, ans, adj, ind);
            
            if(time<temp){
                List<Integer> al = new ArrayList<>();
                
                al.add(ind);
                al.add(inx);
                
                ans.add(al);
            }
            else{
                min_time[ind] = Math.min(min_time[ind], temp);
            }
        }
        
        return min_time[ind];
    }
}