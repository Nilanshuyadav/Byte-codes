class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, val, sum=0;
        long dis;
        
        Map<Long, Integer> map;
        
        for(int i=0; i<n; i++){
            map = new HashMap<>();
            
            for(int j=0; j<n; j++){
                dis = ((points[i][0]-points[j][0])*(points[i][0]-points[j][0])) + ((points[i][1]-points[j][1])*(points[i][1]-points[j][1]));
                
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            
            for(Map.Entry<Long, Integer> entry : map.entrySet()){
                val = entry.getValue();
                
                if(val>=2){
                    sum += ((val)*(val-1));
                }
            }
        
        }
        
        return sum;
    }
}