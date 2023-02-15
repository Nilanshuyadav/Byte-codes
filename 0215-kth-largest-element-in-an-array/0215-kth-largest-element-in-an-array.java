class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        for(int ind : nums){
            if(pq.size()==k){
                if(ind>pq.peek())
                    pq.remove();
                else
                    continue;
            }
            pq.add(ind);
        }
        
        return pq.remove();
    }
}