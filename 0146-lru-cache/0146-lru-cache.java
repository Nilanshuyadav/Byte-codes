class LRUCache {
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(){
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size()>capacity;
            }
        };
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){return -1;}
        
        int val = map.get(key);
        
        map.remove(key);
        map.put(key, val);
        
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */