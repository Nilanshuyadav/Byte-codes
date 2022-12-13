class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        boolean[] vis = new boolean[n], vis2 = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int ind=0; ind<n; ind++){
            List<Integer> al;
            if(map.containsKey(arr[ind]))
                al = map.get(arr[ind]);
            else
                al = new ArrayList<>();
            
            al.add(ind);
            map.put(arr[ind], al);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        int ans = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                int temp = q.remove();
                
                if(temp == n-1)
                    return ans;
                
                if(temp+1<n && !vis[temp+1]){
                    vis[temp+1] = true;
                    q.add(temp+1);
                }
                
                if(0<=temp-1 && !vis[temp-1]){
                    vis[temp-1] = true;
                    q.add(temp-1);
                }
                
                if(vis2[temp])
                    continue;
                
                for(int inx : map.get(arr[temp])){
                    if(!vis[inx]){
                        vis[inx] = true;
                        vis2[inx] = true;
                        q.add(inx);
                    }
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}