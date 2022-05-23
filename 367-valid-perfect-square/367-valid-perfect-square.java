class Solution {
    public boolean isPerfectSquare(int num) {
        long mid;
        long pro;
        int low = 1, high = num;
        
        if(num == 1) return true;
        
        while(low<=high){
            mid = (high+low)/2;
            pro = mid * mid;
            if(pro == num)
                return true;
            else if(pro > num) high = (int)mid-1;
            else low = (int)mid + 1;
        }
        
        return false;
    }
}