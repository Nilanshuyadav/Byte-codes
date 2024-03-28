class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int j=0, max=0, n=nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            int temp = map.getOrDefault(nums[i], 0);
            
            if(temp == k){
                while(nums[j]!=nums[i]){
                    map.put(nums[j], map.get(nums[j])-1);  
                    j++;
                }
                
                j++;
                
                temp--;
            }
            
            map.put(nums[i], temp+1);
            max = Math.max(max, i-j+1);
        }
        
        return max;
    }
}