class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        
        int sum = 0;
        int n = nums.length;
        int count = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(sum == k) count++;
            if(map.containsKey(sum-k)) count += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}