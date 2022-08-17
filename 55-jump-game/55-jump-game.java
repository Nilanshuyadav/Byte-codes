class Solution {
    public boolean canJump(int[] nums) 
    {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int tep = -1;
        for(int i=0;i<n;i++)
            if(nums[i] == 0){
                tep = 0;
                break;
            }
        
        if(tep == -1) return true;
            
        
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