class Solution {
    public int numSteps(String s) {
        int n = s.length();
        
        int total=0, cnt=0;
        
        for(int i=n-1; 0<=i; i--){
            if(s.charAt(i) == '0'){
                total += (cnt+1);
                cnt = cnt==0? 0 : 1;
            }
            else{
                cnt++;
            }
        }
        
        if(cnt!=1){
            total += cnt+1;
        }
        
        return total;
    }
}