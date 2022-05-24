class Solution {
    public int mySqrt(int x) {
        int low=1, high = x;
        long mid,pro;
        
        while(low<=high){
            mid = low + (high-low)/2;
            
            pro = mid * mid;
            
            if(pro == x) return (int)mid;
            else if( pro > x) high = (int)mid-1;
            else low = (int)mid + 1;
        }
        
        return high;
    }
}