class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int pre=0, inx=0;
        
        for(int ind=0; ind<n; ind++){
            if(ind<k-1){
                pq.add(new int[]{nums[ind], ind});
                continue;
            }
            
            pq.add(new int[]{nums[ind], ind});
            
            while(pq.peek()[1]<pre){
                pq.remove();
            }
            
            ans[inx++] = pq.peek()[0];
            pre++;
        }
        
        return ans;
    }
}