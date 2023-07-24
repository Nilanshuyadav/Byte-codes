class Solution {
    public double myPow(double x, long pow) {
        if(x==1) return 1.0;
        if(x==0) return 0.0;
        
        double ans=1;
        
        long n = Math.abs(pow);
        
        while(n>=1){
            if((n&1)!=0){
                ans *= x;
                n--;
                continue;
            }
            
            x *= x;
            n /= 2;
        }
        
        return pow<0 ? 1/ans : ans;
    }
}