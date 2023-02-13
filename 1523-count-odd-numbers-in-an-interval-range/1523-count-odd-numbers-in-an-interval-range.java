class Solution {
    public int countOdds(int low, int high) {
        int temp;
        if((low%2==0 && high%2==0) || (low%2!=0 && high%2!=0)){
            temp = (high - low)/2;
            
            return low%2==0? temp : temp+1;
        }    
        
        return (high-low+1)/2;
    }
}