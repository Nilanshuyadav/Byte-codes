class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        
        solve(0, nums.length, nums, new ArrayList<>(), ans);
        
        return new ArrayList<>(ans);
    }
    
    public void solve(int ind, int n, int[] nums, List<Integer> temp, Set<List<Integer>> ans){
        int temp_size = temp.size();
        
        if(ind == n){
            if(temp_size>1)
                ans.add(new ArrayList<>(temp));
            return;
        }
        
        if(temp_size==0 || temp.get(temp_size-1)<=nums[ind]){
            temp.add(nums[ind]);
            solve(ind+1, n, nums, temp, ans);
            temp.remove(temp_size);
        }
        
        solve(ind+1, n, nums, temp, ans);
    }
}