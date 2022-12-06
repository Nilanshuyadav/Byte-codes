class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        
        int[] result = new int[n-k+1];
        
        for(int ind=0; ind<n; ind++){
            if(!dq.isEmpty() && dq.getFirst()<ind-k+1)
                dq.removeFirst();
            
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[ind])
                dq.removeLast();
            
            dq.addLast(ind);
            if(ind>=k-1)
                result[ind-k+1] = nums[dq.getFirst()];
        }
        
        return result;
    }
}