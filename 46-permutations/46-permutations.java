class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        function(0,nums,ans);
        
        return ans;
    }
    
    public void function(int ind, int[] nums, List<List<Integer>> ans){
        int n = nums.length;
        
        if(ind == n){
            List<Integer> ds = new ArrayList<>();
            
            for(int i = 0;i<n;i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        
        
        for(int i = ind;i<n;i++){
            swap(ind , i, nums);
            function(ind+1,nums,ans);
            swap(ind , i, nums);
        }
    }
    
    public void swap(int a,int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}