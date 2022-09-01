class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int numberOfHops =0;
        int can_travel_max_distance = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int index =0;
        int number_of_stops =0;
        
        while(can_travel_max_distance < target){
            
            while(index<stations.length && can_travel_max_distance>=stations[index][0]){
                pq.add(stations[index][1]);
                index++;
            }
            if(pq.isEmpty()) return -1;
            int max_fuel_on_the_way = pq.peek();
            can_travel_max_distance+=max_fuel_on_the_way;
            pq.poll();
            number_of_stops++;
        }
        return number_of_stops;
        
        
    }
}