class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        for(int ind : nums){
            pq.add(ind);
        }
        
        while(pq.size()>k)
            pq.remove();
        
        return pq.remove();
    }
}