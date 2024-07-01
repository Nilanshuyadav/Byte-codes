class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int cnt=0;
        
        for(int i=0; i<n; i++){
            if((arr[i]&1) != 0){
                cnt++;
            }
            else{
                cnt=0;
            }
            
            if(cnt == 3){
                return true;
            }
        }
        
        return false;
    }
}