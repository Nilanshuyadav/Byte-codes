class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        
        q.add(start);
        vis[start] = true;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            if(arr[temp] == 0) return true;
            int prev = temp-arr[temp],next = temp+arr[temp];
            
            if(prev >= 0 && !vis[prev]){vis[prev] = true; q.add(prev);}
            if(next < n && !vis[next]){vis[next] = true; q.add(next);}
        }
        
        return false;
    }
}