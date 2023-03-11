class MyCalendarThree {
    Map<Integer, Integer> map;
    int k;
    public MyCalendarThree() {
        map = new TreeMap<>();
        k=0;
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);

        int cnt=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            cnt += entry.getValue();
            k = Math.max(k, cnt);
        }

        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */