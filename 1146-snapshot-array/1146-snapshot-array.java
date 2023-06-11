class SnapshotArray {
    List<List<Integer>> al[];
    int snap_id;
    
    public SnapshotArray(int length) {
        al = new ArrayList[length];
        
        for(int ind=0; ind<length; ind++){
            al[ind] = new ArrayList<>();
            
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(0);
            
            al[ind].add(temp);
        }
        
        snap_id = 0;
    }
    
    public void set(int index, int val) {        
        List<Integer> temp = findPos(al[index], snap_id);
        
        if(temp.get(0) == snap_id){
            temp.add(1, val);
            
            return;
        }
        else{
            temp = new ArrayList<>();
        }
        
        temp.add(snap_id);
        temp.add(val);
        
        al[index].add(temp);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        List<Integer> temp = findPos(al[index], snap_id);
        
        return temp.get(1);
    }
    
    public List<Integer> findPos(List<List<Integer>> al, int snap_id){
        int l=0, h=al.size()-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(al.get(m).get(0) == snap_id){
                return al.get(m);
            }
            else if(al.get(m).get(0) < snap_id){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return al.get(h);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */