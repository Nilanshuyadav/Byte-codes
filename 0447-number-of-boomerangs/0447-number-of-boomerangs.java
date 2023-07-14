class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, val, sum=0;
        double dis;
        
        Map<Double, Integer> map;
        
        for(int i=0; i<n; i++){
            map = new HashMap<>();
            
            for(int j=0; j<n; j++){
                dis = Math.sqrt(Math.pow(points[i][0]-points[j][0], 2) + Math.pow(points[i][1]-points[j][1], 2));
                
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            
            for(Map.Entry<Double, Integer> entry : map.entrySet()){
                val = entry.getValue();
                
                if(val>=2){
                    sum += findPer(val);
                }
            }
        
        }
        
        return sum;
    }
    
    public int findPer(int val){
        return val*(val-1);
    }
}