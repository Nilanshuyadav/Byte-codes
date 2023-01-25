class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        
        int[] dis1 = new int[n], dis2 = new int[n];
        
        Arrays.fill(dis1, (int)1e8);
        Arrays.fill(dis2, (int)1e8);
        
        for(int ind=0; ind<n; ind++){
            adj.add(new ArrayList<>());
            if(edges[ind] != -1){
                adj.get(ind).add(edges[ind]);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(node1);
        dis1[node1] = 0;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            
            for(int ind : adj.get(temp)){
                if(dis1[ind]>dis1[temp]+1){
                    dis1[ind] = dis1[temp]+1;
                    q.add(ind);
                }
            }
        }
        
        q.add(node2);
        dis2[node2] = 0;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            
            for(int ind : adj.get(temp)){
                if(dis2[ind]>dis2[temp]+1){
                    dis2[ind] = dis2[temp]+1;
                    q.add(ind);
                }
            }
        }
        
        int max, com=(int)1e8, ans=com, min=com;
        
        for(int ind=0; ind<n; ind++){
            if(dis1[ind]!=com && dis2[ind]!=com){
                
                max = Math.max(dis1[ind], dis2[ind]);
                
                if(max<min){
                    min = max;
                    ans = ind;
                }
            }
        }
        
        return min==com?-1:ans;
    }
}