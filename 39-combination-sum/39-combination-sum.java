class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        function(0,new ArrayList<Integer>(),ans,candidates,target,0);
        return ans;
    }
    
    public void function(int ind,ArrayList<Integer> ds, List<List<Integer>> ans,int[] candidates, int target, int sum){
        
        if(sum == target){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = ind ;i<candidates.length;i++){
            sum += candidates[i];
            ds.add(candidates[i]);
            if(sum<=target) function(i,ds,ans,candidates,target,sum);
            
            sum -= candidates[i];
            ds.remove(ds.size() - 1);
        }
    }
}