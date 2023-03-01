class ProductOfNumbers {
    List<Long> arr;
    long pro;
    int size, last_zero;

    public ProductOfNumbers() {
        arr = new ArrayList<>();
        pro = 1;
        size=0;
        last_zero = -1;
    }
    
    public void add(int num) {
        if(num == 0)    {last_zero = size; pro = 1;}
        else    pro = (pro*num);
        
        arr.add(pro);
        size++;
    }
    
    public int getProduct(int k) {
        int pre = size-k-1;
        
        if(last_zero > pre) return 0;
        
//         System.out.println(pro+" "+arr.get(pre));
        
        return pre==-1 ? (int)pro : (int)(pro/arr.get(pre));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */