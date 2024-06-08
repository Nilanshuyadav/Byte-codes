class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<>();
        
        int num;
        long sum=0;
        
        map.put(0l, -1);
        
        for(int i=0; i<nums.length; i++){
            num = nums[i];
            
            sum += num;
            
            if(!map.containsKey(sum%k)){
                map.put(sum%k, i);
            }
            else if(i-map.get(sum%k)>=2){
                return true;
            }
        }
        
        return false;
    }
}