class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        if(n<0) nn *= -1;
        double ans = 1;
        
        while(nn>0){
            if(nn%2==0){
                x = x*x;
                nn = nn/2;
            }
            
            else {
                ans = ans * x;
                nn -= 1;
            }
        }
        
        
        if(n<0) return (double)1/(double)ans;
        else return ans;
        
        
    }
}