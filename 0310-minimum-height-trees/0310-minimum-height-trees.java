class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return new ArrayList<>(Arrays.asList(0));
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++){
            adj.add(new ArrayList<>());
        }
        
        for(int ind[] : edges){
            adj.get(ind[0]).add(ind[1]);
            adj.get(ind[1]).add(ind[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[n];
        
        for(int ind=0; ind<n; ind++){
            degree[ind] = adj.get(ind).size();
            
            if(degree[ind] == 1){
                q.add(ind);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int temp, size;
        
        while(!q.isEmpty()){
            size = q.size();
            ans.clear();
            
            while(size-->0){
                temp = q.remove();
                
                for(int inx : adj.get(temp)){
                    degree[inx]--;
                    
                    if(degree[inx] == 1){
                        q.add(inx);
                    }
                }
                
                ans.add(temp);
            }
        }
        
        return ans;
    }
}