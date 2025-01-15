class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt=0;

        while(num2>0){
            cnt += (num2&1);
            num2 = num2>>1;
        }

        int ans=0, i=31;
        
        while(cnt>0 && i>=0){
            if((num1&(1<<i))!=0){
                ans |= (1<<i);
                cnt--;
            }

            i--;
        }

        i=0;
        while(cnt>0){
            if((ans&(1<<i)) == 0){
                ans |= (1<<i);
                cnt--;
            }

            i++;
        }

        return ans;
    }
}