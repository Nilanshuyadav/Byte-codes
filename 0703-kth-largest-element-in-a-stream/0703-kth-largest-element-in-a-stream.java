class KthLargest {
    PriorityQueue<Integer> pq;
    int l;
    
    public KthLargest(int k, int[] nums) {
        l = k;
        pq = new PriorityQueue<>();
        
        for(var n : nums){
            add(n);
        }
        
        // l = k;
    }
    
    public int add(int val) {
        pq.offer(val);
        
        if(pq.size() > l){
            pq.poll();
        }
        
        return pq.peek();
    }
}



/*******************************************************************

class KthLargest {
  private PriorityQueue<Integer> heap = new PriorityQueue<>();
  private int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (var n : nums) add(n);
  }
  
  public int add(int val) {
    heap.offer(val);
    if (heap.size() > k) heap.poll();
    return heap.peek();
  }
}

*******************************************************************/



/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */