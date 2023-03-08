class Solution {
    public long coloredCells(int n) {
        return solve(n);
    }
    
    public long solve(int n){
        if(n==1){
            return 1;
        }
        
        long temp = (n-1)*4 + solve(n-1);
        return temp;
    }
}