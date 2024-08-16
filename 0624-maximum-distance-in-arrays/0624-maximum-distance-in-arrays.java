class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min=0, max2=0;
        List<Integer> al;
        
        for(int i=0; i<arrays.size(); i++){
            if(arrays.get(i).get(0) < arrays.get(min).get(0)){
                min = i;
            }
            
            al = arrays.get(i);
            
            if(al.get(al.size()-1) > arrays.get(max2).get(arrays.get(max2).size()-1)){
                max2 = i;
            }
        }
        
        int max= min==0 ? 1 : 0, min2= max2==0?1:0;
        
        for(int i=0; i<arrays.size(); i++){
            if(i != min){
                al = arrays.get(i);
                
                if(al.get(al.size()-1) > arrays.get(max).get(arrays.get(max).size()-1)){
                    max = i;
                }
            }
            
            if(i != max2){
                if(arrays.get(i).get(0) < arrays.get(min2).get(0)){
                    min2 = i;
                }
            }
        }

        
        return Math.max(arrays.get(max).get(arrays.get(max).size()-1) - arrays.get(min).get(0),
                    arrays.get(max2).get(arrays.get(max2).size()-1) - arrays.get(min2).get(0));
    }
}