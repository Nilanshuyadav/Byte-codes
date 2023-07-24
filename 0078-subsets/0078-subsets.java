class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        
        solve(0, nums, nums.length, new ArrayList<>());
        
        return ans;
    }
    
    public void solve(int ind, int[] nums, int n, List<Integer> al){
        if(ind == n){
            ans.add(new ArrayList<>(al));
            return;
        }
        
        al.add(nums[ind]);
        solve(ind+1, nums, n, al);
        
        al.remove(al.size()-1);
        solve(ind+1, nums, n, al);
    }
}