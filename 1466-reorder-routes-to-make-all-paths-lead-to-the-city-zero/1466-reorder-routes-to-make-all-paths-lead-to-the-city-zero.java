class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean[] vis = new boolean[n];
        vis[0] = true;
        Set<String> set = new HashSet<>();
        for(int i[] : connections)
            set.add(new StringBuilder()
                    .append(i[0])
                    .append(",")
                    .append(i[1])
                    .toString());
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int i[] : connections){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int ans = 0 ;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            
            for(int i : adj.get(temp)){
                if(!vis[i]){
                    if(set.contains(new StringBuilder()
                                    .append(temp)
                                    .append(",")
                                    .append(i)
                                    .toString())) ans++;
                    vis[i] = true;
                    q.add(i);
                }    
            }
        }
        return ans;
    }
}