class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        
        function(0,candidates,candidates.length,target,ans,new ArrayList<Integer>());
        
        return ans;
    }
    
    public void function(int ind, int[] candidates, int N, int target, List<List<Integer>> ans, ArrayList<Integer> ds){
        if(target == 0){ ans.add(new ArrayList<>(ds)); return;}
        if(ind == N) return;
        
        for(int i = ind;i<N;i++){
            if(i != ind && candidates[i] == candidates[i-1]) continue;
            ds.add(candidates[i]);
            if(target >= candidates[i]) function(i+1,candidates,N,target-candidates[i],ans,ds);
            
            ds.remove(ds.size() - 1);
            if(target < candidates[i])return;
            
        }
        
    }
}