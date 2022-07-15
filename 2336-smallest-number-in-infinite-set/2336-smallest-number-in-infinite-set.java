class SmallestInfiniteSet {

    int[] arr;
    
    public SmallestInfiniteSet() {
        arr = new int[1001];
        for(int i=0;i<1001;i++)
            arr[i] = i;
    }
    
    public int popSmallest() {
        for(int i: arr)
            if(i != 0){
                arr[i] = 0;
                return i;
            }
        
        return 0;
    }
    
    public void addBack(int num) {
        arr[num] = num;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */