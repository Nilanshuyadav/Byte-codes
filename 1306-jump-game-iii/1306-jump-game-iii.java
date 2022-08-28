class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0) return true;
        int n = arr.length;
        boolean[] vis=  new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        
        int[] r = {1,-1};
        
        while(!q.isEmpty()){
            int temp = q.remove();
            
            for(int i=0;i<2;i++){
                int new_ind = temp + (r[i]*arr[temp]);
                if(new_ind<0 || new_ind>=n || vis[new_ind]) continue;
                if(arr[new_ind] == 0) return true;
                vis[new_ind] = true;
                q.add(new_ind);
            }
        }
        return false;
    }
}