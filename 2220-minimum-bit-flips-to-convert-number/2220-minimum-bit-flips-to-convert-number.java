class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start^goal,
        ans=0;
        
        while(xor>0){
            ans += (xor&1);
            xor = xor>>1;
        }
        
        return ans;
    }
}