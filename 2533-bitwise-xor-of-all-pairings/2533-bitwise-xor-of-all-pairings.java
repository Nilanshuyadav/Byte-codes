class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int ans = 0;

        if((m&1)!=0){
            for(int i : nums1){
                ans ^= i;
            }
        }

        if((n&1)!=0){
            for(int i : nums2){
                ans ^= i;
            }
        }


        return ans;
    }
}