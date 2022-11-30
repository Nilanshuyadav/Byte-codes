class Solution {
    public int pivotInteger(int n) {
        int temp = (n*(n+1))/2;
        
        for(int ind=1; ind<=n; ind++){
            if(ind*ind == temp)
                return ind;
        }
        
        return -1;
    }
}