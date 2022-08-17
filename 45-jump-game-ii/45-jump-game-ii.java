class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        if(n==1) return 0;
        q.add(0);
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int temp = q.remove();
                
                for(int i =0;i<=nums[temp];i++){
                    if(temp+i >= n) break;
                    if(temp+i == n-1) return step;
                    if(!vis[temp+i]){
                        vis[temp+i] = true;
                        q.add(temp+i);
                    }
                }
            }
            step++;
        }
        return 0;
    }
}