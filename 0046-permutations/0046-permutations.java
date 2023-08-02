class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;
        
        boolean[] vis = new boolean[n];
        
        solve(0, n, nums, vis, new ArrayList<>());
        return ans;
    }
    
    public void solve(int ind, int n, int[] nums, boolean[] vis, List<Integer> al){
        if(ind == n){
            ans.add(new ArrayList<>(al));
            return;
        }    
        
        for(int i=0; i<n; i++){
            if(!vis[i]){
                vis[i] = true;
                al.add(nums[i]);
                solve(ind+1, n, nums, vis, al);
                
                al.remove(al.size()-1);
                vis[i] = false;
            }
        }
    }
}