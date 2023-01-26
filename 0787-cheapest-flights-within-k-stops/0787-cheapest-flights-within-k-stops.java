class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : flights)
            adj.get(ind[0]).add(new int[]{ind[1], ind[2]});
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        pq.add(new int[]{src, 0, k+1});
        int[][] vis = new int[n][k+2];
        for(int ind[] : vis)
            Arrays.fill(ind, Integer.MAX_VALUE);
        
        for(int ind=0; ind<k+2;ind++) 
            vis[src][ind]= 0;
        
        int temp[], from, price, temp_k, min = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            temp = pq.remove();
            
            from = temp[0];
            price = temp[1];
            temp_k = temp[2];
            
            if(from == dst)
                min = Math.min(price, min);
            
            for(int ind[] : adj.get(from)){
                if(temp_k>0){
                    if(vis[ind[0]][temp_k]>price+ind[1]){
                        vis[ind[0]][temp_k] = price+ind[1];
                        pq.add(new int[]{ind[0], price+ind[1], temp_k-1});
                    }
                }
            }
        }
        
        if(min != Integer.MAX_VALUE)
            return min;
        
        return -1;
    }
    
//     public long solve(int src, int dst, int k, List<List<int[]>> adj, boolean[] vis){
//         if(src==dst)
//             return 0;
//         if(k==-1)
//             return (int)1e8;
        
//         vis[src] = true;
//         long min = (int)1e8;
        
//         for(int[] inx : adj.get(src)){
//             if(!vis[inx[0]]){
//                 min = Math.min(min, inx[1] + solve(inx[0], dst, k-1, adj, vis));
//             }           
//         }
        
//         vis[src] = false;
        
//         return min>=1e8?(int)1e8:min;
//     }
}