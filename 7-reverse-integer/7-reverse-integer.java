class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x<0) neg = true;
        x = Math.abs(x);
        long ans = 0;
        
        while(x>0){
            long dig = x%10;
            x = x/10;
            ans = (ans*10)+dig;
            if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE) return 0;
        }
        
        return neg==true?(int)(-1*ans):(int)ans;
    }
}