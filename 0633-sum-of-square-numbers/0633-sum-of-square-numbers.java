class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0) return true;
        
        long l=1, h=c, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if((m*m)>c){
                h = m-1;
            }
            else{
                l = m + 1;
            }
        }
        
        for(int i=1; i<=l; i++){
            if(helper((c-(i*i)))){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean helper(int num){
        return Math.sqrt(num)%1 == 0;
    }
}