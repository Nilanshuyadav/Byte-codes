class MyHashSet {
    
    List<Integer> set;
    int size;
    
    public MyHashSet() {
        set = new ArrayList<>();
        size = 0;
    }
    
    public void add(int key) {        
        int pos = findPos(set, key);
        
        if(pos==size || set.get(pos)!=key){
            set.add(pos, key);
            size++;
        } 
    }
    
    public void remove(int key) {
        int pos = findPos(set, key);
        
        if(pos!=size && set.get(pos)==key){
            set.remove(pos);
            size--;
        }
    }
    
    public boolean contains(int key) {
        int pos = findPos(set, key);
        
        if(pos!=size && set.get(pos)==key){
            return true;
        }
        
        return false;
    }
    
    public int findPos(List<Integer> al, int key){
        int l=0, h=al.size()-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(al.get(m) == key){
                return m;
            }
            else if(al.get(m) < key){
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
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */