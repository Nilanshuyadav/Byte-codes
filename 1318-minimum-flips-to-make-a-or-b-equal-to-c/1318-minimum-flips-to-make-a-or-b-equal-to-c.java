class Solution {
    public int minFlips(int a, int b, int c) {
        int or = a|b;
        
        int ind=0, cnt=0;
        
        while(ind<32){
            int a_ind = a&(1<<ind);
            int b_ind = b&(1<<ind);
            
            int c_ind = c&(1<<ind);
            int or_ind = or&(1<<ind);
            
            if(c_ind != or_ind){
                if(c_ind==0){
                    if(a_ind == b_ind){
                        cnt += 2;
                    }
                    else{
                        cnt += 1;
                    }
                }
                else{
                    cnt += 1;
                }
            }
            
            ind++;
        }
        
        return cnt;
    }
}