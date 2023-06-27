class MedianFinder {
    List<Double> al;
    int size;
    
    public MedianFinder() {
        al = new ArrayList<>();
        size = 0;
    }
    
    public void addNum(int num) {
        int pos = findPos(al, num);
        
        al.add(pos, (double)num);
        size++;
    }
    
    public double findMedian() {
        double sum = al.get((size-1)/2) + al.get((size)/2);
        return sum/2;
    }
    
    public int findPos(List<Double> al, double num){
        int l=0, h=al.size()-1, m;
        
        while(l <= h){
            m = l + (h-l)/2;
            
            if(al.get(m) == num){
                return m;
            }
            else if(al.get(m) < num){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return h+1;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */