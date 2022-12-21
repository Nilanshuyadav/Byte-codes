class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<=n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : dislikes){
            adj.get(ind[0]).add(ind[1]);
            adj.get(ind[1]).add(ind[0]);
        }
        
        Boolean[] vis = new Boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int inx=1; inx<=n; inx++){
            if(vis[inx]==null){
                vis[inx] = true;
                q.add(inx);

                while(!q.isEmpty()){
                    int temp = q.remove();
                    boolean color = vis[temp];

                    for(int ind : adj.get(temp)){
                        if(vis[ind] != null){
                            if(vis[ind]==color)
                                return false;
                        }
                        else{
                            vis[ind] = !color;
                            q.add(ind);
                        }
                    }
                }       
            }
        }
        
        return true;
    }
}