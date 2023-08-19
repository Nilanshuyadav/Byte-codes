class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<Pair> al = map.get(key);
            
            int index = findPos(al, timestamp+1), size=al.size();
            
            if(index!=0){
                return al.get(index-1).value;
            }
        }
        
        return "";
    }
    
    public int findPos(List<Pair> al, int t){
        int l=0, h=al.size()-1, m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(al.get(m).time == t){
                return m;
            }
            else if(al.get(m).time < t){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return h+1;
    }
}

class Pair{
    int time;
    String value;
    
    public Pair(int time, String value){
        this.time = time;
        this.value = value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */