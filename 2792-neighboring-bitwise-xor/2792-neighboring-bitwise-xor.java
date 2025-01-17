class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        return helper(1, derived)==1 || helper(0, derived)==0;
    }

    public int helper(int s, int[] derived){
        for(int i : derived){
            s ^= i;
        }

        return s;
    }
}