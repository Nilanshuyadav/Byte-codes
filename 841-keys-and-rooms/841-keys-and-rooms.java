class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        q.add(0);
        
        while(!q.isEmpty()){
            int temp = q.remove();

            for(int i : rooms.get(temp))
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
        }
        
       
        for(boolean bool : vis)
            if(bool != true)
                return false;  
        
        return true;
    }
}