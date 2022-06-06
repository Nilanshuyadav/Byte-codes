class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums == null || n==0) return ans;
        
        Arrays.sort(nums);
        
        for(int i=0;i<n-3;i++){
            for(int j = i+1;j<n-2;j++){
                int left = j+1, right = n-1;
                int to_find = target - nums[i] - nums[j];
                
                while(left < right && left<n && right>j){
                    int second_two_sum = nums[left] + nums[right];
                    
                    if(second_two_sum > to_find) right--;
                    else if(second_two_sum < to_find) left++;
                    else{ 
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        
                        ans.add(list);
                        
                        while(left<right && nums[left] == list.get(2)) left++;
                        while(right>left && nums[right] == list.get(3)) right--;
                    }    
                }
                
                while(j<n-2 && nums[j+1] == nums[j]) j++;
            }
            
            while(i<n-3 && nums[i+1] == nums[i]) i++;
        }
        
        return ans;
    }
}