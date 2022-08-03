class MyCalendar {
    List<int[]> al;
    public MyCalendar() {
        al = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int n = al.size();
        
        if(n == 0){
            al.add(new int[]{start,end});
            return true;
        }
        
        else{
            int i = 0;
            while(i<n && al.get(i)[0] < start) i++;
            
            if(i == n){
                if(start>=al.get(i-1)[1]){
                    al.add(new int[]{start,end});
                    return true;    
                }
                else return false;
            } 
            else if(end <= al.get(i)[0] && (i==0 || start >= al.get(i-1)[1])){
                al.add(i,new int[]{start,end});
                return true;
            }
            
            else return false;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */