class Solution {
    public boolean canJump(int[] nums) 
    {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        
        q.add(0);
        
        while(!q.isEmpty()){
            int temp = q.remove();
            
            for(int i=0;i<=nums[temp];i++){
                if(temp+i>=n) break;
                if(temp+i == n-1) return true;
                if(!vis[temp+i]){
                    vis[temp+i] = true;
                    q.add(temp+i);
                }
            }
        }
        return false;
    }
}