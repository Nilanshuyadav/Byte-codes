class Solution {
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        
        long ans=0;
        
        ans = (power(5, even) * power(4, odd))%1000000007;
        
        return (int)ans;
    }
    
    public long power(long a, long b){
        long ans=1;
        
        while(b>0){
            if((b&1)!=0){
                ans = (ans * a)%1000000007;
                b = b-1;
            }

            a = (a*a)%1000000007;
            b = b/2;    
        }
        
        return ans;
    }
}