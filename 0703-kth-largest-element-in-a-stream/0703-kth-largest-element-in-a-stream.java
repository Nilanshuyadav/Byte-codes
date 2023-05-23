class KthLargest {
    List<Integer> al;
    int k;
    
    public KthLargest(int k, int[] nums) {
        al = new ArrayList<>();
        
        for(int n : nums){
            al.add(n);
        }
        this.k = k;
    }
    
    public int add(int val) {
        al.add(val);
        
        Collections.sort(al, Collections.reverseOrder());
        return al.get(k-1);
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