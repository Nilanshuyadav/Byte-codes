class Solution {
    public int pivotInteger(int n) {
        int temp = (n*(n+1))/2;
        
        int low=1;
        int high = n;
        
        while(low<=high){
            int mid = low+((high-low)/2);
            
            int sq = mid*mid;
            
            if(sq == temp)
                return mid;
            else if(sq < temp)
                low = mid+1;
            else
                high = mid-1;
        }
        
        return -1;
    }
}