class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1] - a[1]);
       
        
        int ans = 0;
        
        for(int[] i : boxTypes){
            if(truckSize <= 0) break;
            
            if(i[0] <= truckSize){
                ans += i[0]*i[1];
                truckSize -= i[0];
            }    
            else{
                ans += truckSize * i[1];
                truckSize = 0;
            }
        }
        
        return ans;
    }
}