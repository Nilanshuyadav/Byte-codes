class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        
        List<List<Integer>> ans = new ArrayList();
        
        if(n < 3) return ans; 
            
        for(int i=0;i<n-2;i++){
            int tocheck = 0 - nums[i];
            
            int low = i+1,high = n-1;
            
            while(low<high){
                int sum = nums[low] + nums[high];
                
                if(sum == tocheck){
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[low]);
                    lst.add(nums[high]);
                    
                    ans.add(lst);
                    
                    while(low<high && nums[low]==nums[low+1]) low++;
                    while(high > low && nums[high] == nums[high-1])high--;
                    
                    low++;
                    high--;
                }
                
                else if(sum > tocheck) high--;
                else low++;
            }
            
            while(i<n-2 && nums[i] == nums[i+1]) i++;
        }
        
        return ans;
    }
    
    
}