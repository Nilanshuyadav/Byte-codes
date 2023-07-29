class Solution {
    int[] arr_a = {100,75,50,25}, arr_b={0,25,50,75};
    
    public double soupServings(int n) {
        if(n>=4801){
            return 1.0;
        }
        
        Map<String, Double> dp = new HashMap<>();
        
        return solve(n, n, dp);
    }
    
    public double solve(int a, int b, Map<String, Double> map){
        double sum = 0;
        
        String st = a+","+b;
        
        if(map.containsKey(st)){
            return map.get(st);
        }
        
        int new_a, new_b;
        for(int ind=0; ind<4; ind++){
            new_a = a-arr_a[ind];
            new_b = b-arr_b[ind];
            
            if(new_a<=0 && new_b<=0){
                sum += 0.5;
            }
            else if(new_a<=0){
                sum += 1;
            }
            else if(new_b<=0){
                sum += 0;
            }
            else{
                sum += solve(new_a, new_b, map);
            }
        }
        
        map.put(st, 0.25*sum);
        
        return map.get(st);
    }
}