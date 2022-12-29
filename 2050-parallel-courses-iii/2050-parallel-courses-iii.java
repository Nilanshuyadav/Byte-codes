class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Queue<Integer> q = new LinkedList<>();
        
        int[] indegree = new int[n+1], max_time = new int[n+1];
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<=n; ind++){
            adj.add(new ArrayList<>());    
        }
        
        for(int ind[] : relations){
            indegree[ind[1]]++;
            adj.get(ind[0]).add(ind[1]);
        }
        
        for(int ind=1; ind<=n; ind++)
            if(indegree[ind] == 0)
                q.add(ind);
        
        while(!q.isEmpty()){
            int temp = q.remove();
            
            for(int ind : adj.get(temp)){
                max_time[ind] = Math.max(max_time[ind], max_time[temp]+time[temp-1]);
                
                indegree[ind]--;
                if(indegree[ind] == 0)
                    q.add(ind);
            }
        }
        
        int max=0;
        for(int ind=1; ind<=n; ind++)
            max = Math.max(max, time[ind-1]+max_time[ind]);
        
        return max;
    }
}