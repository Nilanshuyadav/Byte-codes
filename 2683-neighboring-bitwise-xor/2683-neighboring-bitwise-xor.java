class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int cnt=0;
        
        for(int ind : derived){
            if(ind == 1)
                cnt++;
        }
        
        return (cnt&1)==0;
    }
}