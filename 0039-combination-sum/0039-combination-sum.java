class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        
        int n = candidates.length;
        
        dfs(0, new ArrayList<>(), candidates, n, target);
        
        return ans;
    }
    
    public void dfs(int ind, List<Integer> al, int[] candidates, int n, int target){
        if(n <= ind){
            if(target == 0)
                ans.add(new ArrayList<>(al));
            
            return;
        }
        
        if(candidates[ind] <= target){
            al.add(candidates[ind]);
            dfs(ind, al, candidates, n, target-candidates[ind]);
            al.remove(al.size()-1);
        }
        
        dfs(ind+1, al, candidates, n, target);
    }
}