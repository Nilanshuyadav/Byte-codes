class Solution {
    public int commonFactors(int a, int b) {
        int cnt=0;
        
        for(int ind=1; ind<=Math.min(a,b); ind++)
            if(a%ind==0 && b%ind==0)
                cnt++;
        
        return cnt;
    }
}