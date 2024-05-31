class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        
        int xor = 0;
        
        for(int i : nums){
            xor ^= i;
        }
        
        int mask = xor&(-xor);
        
        int bucket1=0, bucket2=0;
        
        for(int i : nums){
            if((i&mask) == 0){
                bucket1 ^= i;
            }
            else{
                bucket2 ^= i;
            }
        }
        
        return new int[]{bucket1, bucket2};
    }
}