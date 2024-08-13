class Solution {
    Set<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new HashSet<>();
        Arrays.sort(candidates);
        
        Set<List<Integer>> dp[] = new Set[101];
        
        helper(candidates.length-1, candidates, target, new ArrayList<>(), dp);
        return new ArrayList<>(ans);
    }
    
    public void helper(int ind, int[] candidates, int tar, List<Integer> al, Set<List<Integer>> dp[]){
        if(ind == -1){
            if(tar==0){
                ans.add(new ArrayList<>(al));
            }
            
            return;
        }
        
        if(dp[ind]==null){
            dp[ind] = new HashSet<>();
        }
        
        if(!dp[ind].add(new ArrayList<>(al))){
            return;
        }
        
        if(candidates[ind]<=tar){
            al.add(candidates[ind]);
            helper(ind-1, candidates, tar-candidates[ind], al, dp);
            al.remove(al.size()-1);
        }
        
        helper(ind-1, candidates, tar, al, dp);
        
    }
}