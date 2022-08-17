class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        
        ans = new ArrayList<>();
        
        function(0,candidates,target,n,new ArrayList<Integer>());
        
        return ans;
    }
    
    public void function(int ind,int[] candidates,int target,int n, List<Integer> temp){
        
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=ind;i<n;i++){
            if(i != ind && candidates[i] == candidates[i-1]) continue;
            
            if(target-candidates[i] < 0) return;
            temp.add(candidates[i]);
            if(target >= candidates[i])function(i+1,candidates,target-candidates[i],n,temp);
            temp.remove(temp.size()-1);
            
        }
    }
}