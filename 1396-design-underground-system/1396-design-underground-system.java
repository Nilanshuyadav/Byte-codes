class UndergroundSystem {
    Map<Integer, Pair> map;
    Map<String, Pair> totalTime;

    public UndergroundSystem() {
        map = new HashMap<>();
        totalTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        map.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair temp = map.get(id);
        
        String start = temp.station;
        int startTime = temp.time;
        
        String st = start+","+stationName;
        
        totalTime.putIfAbsent(st, new Pair((double)0, 0));
        
        temp = totalTime.get(st);
        temp.total += (t-startTime);
        temp.n += 1;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String st = startStation+","+endStation;
        
        return totalTime.get(st).total/totalTime.get(st).n;
    }
}

class Pair{
    String station;
    int time;
    double total;
    int n;
    
    public Pair(String station, int time){
        this.station = station;
        this.time = time;
    }
    
    public Pair(double total, int n){
        this.total = 0;
        this.n = 0;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */