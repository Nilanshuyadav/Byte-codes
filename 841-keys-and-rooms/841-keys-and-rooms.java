class Solution {
    boolean[] vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int V = rooms.size();
        vis = new boolean[V];
        
        function(rooms,0);
        
        for(int i=0;i<V;i++)
            if(vis[i] != true) return false;
        
        return true;
    }
    
    public void function(List<List<Integer>> rooms, int ind){
        vis[ind] = true;
        
        for(int i : rooms.get(ind)){
            if(vis[i] == true) continue;
            function(rooms,i);
        }
    }
}