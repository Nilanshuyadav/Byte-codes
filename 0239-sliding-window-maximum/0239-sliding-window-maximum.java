class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int i=0, n=nums.length,  ans[] = new int[n-k+1];
        
        for(int ind=0; ind<n; ind++){
            pq.add(new int[]{nums[ind], ind});
            
            if(ind>=k-1){
                ans[i++] = pq.peek()[0];
                
                while(!pq.isEmpty() && pq.peek()[1]<=ind-k+1){
                    pq.remove();
                }
            }
        }
        
        return ans;
    }
}