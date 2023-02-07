class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int n = fruits.length, i=0, j=0;
        int max = 0;
        
        for(int ind=0; ind<n; ind++){

            while(map.size()==2 && !map.containsKey(fruits[ind])){
                map.put(fruits[j], map.get(fruits[j])-1);
                if(map.get(fruits[j])==0){
                    map.remove(fruits[j]);
                }

                j++;
            }
            
            map.put(fruits[ind], map.getOrDefault(fruits[ind], 0)+1);
            
            int sum = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                sum += entry.getValue();
            }
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
}