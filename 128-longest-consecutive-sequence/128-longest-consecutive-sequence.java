class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0,n = nums.length;
        int count = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i]-1)){
                int value = nums[i];
                while(map.containsKey(value+1)){
                    value += 1;
                    count++;
                }    
                
                if(count+1 > max) max = count+1;
            }
            count = 0;
        }
        
        return max;
    }
}