class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        int n = candidates.length;
        
        solve(0, candidates, n, target, new ArrayList<>());
        
        return ans;
    }
    
    public void solve(int ind, int[] candidates, int n, int target, List<Integer> temp){
        if(target == 0){
            ans. add(new ArrayList<>(temp));
            return;
        }
        
        if(ind == n){
            return;
        }
        
        if(candidates[ind] <= target){
            temp.add(candidates[ind]);
            solve(ind, candidates, n, target-candidates[ind], temp);
            temp.remove(temp.size()-1);
        }
        
        solve(ind+1, candidates, n, target, temp);
        
        return;
    }
}