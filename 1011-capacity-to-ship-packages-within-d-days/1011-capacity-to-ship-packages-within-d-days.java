class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE, sum = 0;
        
        for(int ind : weights){
            max = Math.max(max, ind);
            sum += ind;
        }
        int min=Integer.MAX_VALUE;
        
        int low = max, high = sum;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(dfs(weights, mid)<=days){
                min = Math.min(min, mid);
                high = mid-1;
            }
            else
                low++;
        }
        
        return min;
    }
    
    public int dfs(int[] weights, int mid){
        int days = 1, sum = 0;
        
        for(int ind : weights){
            sum += ind;
            
            if(mid<sum){
                days++;
                sum = ind;
            }
        }
        
        return days;
    } 
}