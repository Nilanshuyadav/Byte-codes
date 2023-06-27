class MedianFinder {
    PriorityQueue<Integer> small, large;
    int small_size, large_size;
    
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        
        small_size=0;
        large_size=0;
    }
    
    public void addNum(int num) {
        small.add(num);
        small_size++;
        
        if(large_size>0 && small.peek()>large.peek()){
            large.add(small.remove());
            
            small_size--;
            large_size++;
        }
        
        if(small_size-large_size > 1){
            large.add(small.remove());
            
            small_size--;
            large_size++;
        }
        
        if(large_size-small_size > 1){
            small.add(large.remove());
            
            small_size++;
            large_size--;
        }
    }
    
    public double findMedian() {
        if(small_size == large_size){
            return ((double)(small.peek() + large.peek()))/2;
        }
        
        return small_size>large_size ? small.peek() : large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */