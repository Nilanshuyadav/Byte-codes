class Solution {
    public int integerReplacement(int n) {
        int cnt=0;
        
        while(n!=1){
            if(n == 2147483647){
                return 32;
            }
            
            if(n==3){
                return cnt+2;
            }
            if((n&1) == 0){
                n /= 2;
            }
            else if((((n+1)/2)&1) == 0){
                n++;
            }
            else{
                n--;
            }
            
            cnt++;
        }
        
        return cnt;
    }
}