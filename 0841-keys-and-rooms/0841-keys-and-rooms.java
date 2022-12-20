class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        
        boolean[] vis = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            
            for(int ind : rooms.get(temp)){
                if(!vis[ind]){
                    vis[ind] = true;
                    q.add(ind);
                }
            }
        }
        
        for(boolean v : vis)
            if(!v)
                return false;
        
        return true;
    }
}