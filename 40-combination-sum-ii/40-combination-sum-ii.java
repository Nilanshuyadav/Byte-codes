class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        
        ans = new ArrayList<>();
        
        function(0,candidates,target,n,new ArrayList<Integer>(),0);
        
        return ans;
    }
    
    public void function(int ind,int[] candidates,int target,int n, List<Integer> temp,int sum){
        if(sum > target) return;
        if(target == sum){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=ind;i<n;i++){
            if(i != ind && candidates[i] == candidates[i-1]) continue;
            sum += candidates[i];
            temp.add(candidates[i]);
            function(i+1,candidates,target,n,temp,sum);
            temp.remove(temp.size()-1);
            sum -= candidates[i];
        }
    }
}