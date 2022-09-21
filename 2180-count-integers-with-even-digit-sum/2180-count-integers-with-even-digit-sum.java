class Solution {
    public int countEven(int num) {
        int cnt =0 ;
        for(int ind = 1; ind<=num; ind++){
            if(isEven(ind)) cnt++;
        }
        return cnt;
    }
    
    public boolean isEven(int n){
        int sum  =0;
        while(n>0){
            sum += n%10;
            n = n/10;
        }
        
        return sum%2==0;
    }
}