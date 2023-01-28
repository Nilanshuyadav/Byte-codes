class SummaryRanges {
    List<int[]> store, toShow;
    int size;

    public SummaryRanges() {
        store = new ArrayList<>();
        size = 0;
    }
    
    public void addNum(int value) {
        toShow = new ArrayList<>();
        
        int temp_size = size;
        
        if(store.isEmpty()){
            toShow.add(new int[]{value, value});
            temp_size++;
        }
        else{
            int ind, start=value, end=value;
            
            for(ind=0; ind<size; ind++){
                if(store.get(ind)[0]<=value && value<=store.get(ind)[1]){
                    ind--;
                    break;
                }
                
                if(ind==0){
                    if(value+1==store.get(ind)[0]){
                        end = store.get(ind)[1];
                        toShow.add(new int[]{start, end});
                        ind++;
                        break;
                    }
                    
                    if(end!=value || value<store.get(ind)[0]){
                        toShow.add(new int[]{start, end});
                        
                        ind = end!=value?ind+1 : ind;
                        temp_size = end!=value?temp_size : temp_size+1;
                        break;
                    }
                }
                else{
                    if(value+1==store.get(ind)[0]){
                        end = store.get(ind)[1];
                    }
                    
                    if(value-1==store.get(ind-1)[1]){
                        start = store.get(ind-1)[0];
                    }
                    else{
                        toShow.add(store.get(ind-1));
                    }
                    
                    if(start!=value || end!=value || value<store.get(ind)[0]){
                        toShow.add(new int[]{start, end});
                        
                        if(end!=value){
                            ind++;
                        }
                       
                        if(end!=value && start!=value){
                            temp_size--;
                        }
                        else if(start==value && end==value){
                            temp_size++;
                        }
                        
                        break;
                    }
                }
            }
            
            if(ind==size && start==end){
               if(value-1==store.get(ind-1)[1]){
                    start = store.get(ind-1)[0];
                }
                else{
                    toShow.add(store.get(ind-1));
                    temp_size++;
                }
                
                toShow.add(new int[]{start, end});
            }
            
            for(ind=Math.max(0,ind); ind<size; ind++){
                toShow.add(store.get(ind));
            }
        }
        
        store = toShow;
        size = temp_size;
    }
    
    public int[][] getIntervals() {
        return store.toArray(new int[size][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */