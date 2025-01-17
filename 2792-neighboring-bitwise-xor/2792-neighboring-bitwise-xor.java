class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        return helper(1, derived)==1;
    }

    public int helper(int s, int[] derived){
        for(int i : derived){
            s ^= i;
        }

        return s;
    }
}