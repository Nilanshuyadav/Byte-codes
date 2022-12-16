class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        int n = nums.length;
        Arrays.sort(nums);
        
        dfs(0, nums, new ArrayList<>(), set);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(List<Integer> al : set)
            ans.add(al);
        
        return ans;
    }
    
    public void dfs(int ind, int[] nums, List<Integer> al, Set<List<Integer>> set){
        if(nums.length<=ind){
            if(!set.contains(al))
                set.add(new ArrayList<>(al));
            
            return;
        }
        
        al.add(nums[ind]);
        dfs(ind+1, nums, al, set);
        
        al.remove(al.size()-1);
        dfs(ind+1, nums, al, set);
    }
}