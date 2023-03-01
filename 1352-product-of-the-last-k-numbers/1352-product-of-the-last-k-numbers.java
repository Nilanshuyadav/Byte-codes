class ProductOfNumbers {
    List<Long> arr;
    int size;

    public ProductOfNumbers() {
        arr = new ArrayList<>();
        arr.add((long)1);
        size=1;
    }
    
    public void add(int num) {
        if(num == 0)    {arr.clear(); arr.add((long)1); size=0;}
        else    arr.add(arr.get(size-1)*num);
        size++;
    }
    
    public int getProduct(int k) {
        if(size<=k)  return 0;
        
        return (int)(arr.get(size-1)/arr.get(size-k-1));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */