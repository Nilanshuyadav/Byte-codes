class Solution {
    public int longestConsecutive(int[] nums) {
       
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        
        
        for(int i=0;i<n;i++)
            set.add(nums[i]);
        
        int max = 0,count = 1;
        
        for(int num : nums){
            if(!set.contains(num-1)){
                while(set.contains(++num))
                    count++;
                
                max = Math.max(max,count);
                count = 1;
            }
        }
        return max;
    }
}