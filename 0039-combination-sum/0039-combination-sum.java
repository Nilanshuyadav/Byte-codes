class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        
        int n = candidates.length;
        int[][] dp = new int[n][target+1];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
        
        dfs(0, new ArrayList<>(), candidates, n, target, dp);
        
        return ans;
    }
    
    public void dfs(int ind, List<Integer> al, int[] candidates, int n, int target, int[][] dp){
        if(n <= ind){
            if(target == 0)
                ans.add(new ArrayList<>(al));
            
            return;
        }
        
        if(candidates[ind] <= target){
            al.add(candidates[ind]);
            dfs(ind, al, candidates, n, target-candidates[ind], dp);
            al.remove(al.size()-1);
        }
        
        dfs(ind+1, al, candidates, n, target, dp);
    }
}