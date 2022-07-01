class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        
        function(0,new ArrayList<Integer>(),ans,nums);
        
        return ans;
    }
    
    public void function(int ind,ArrayList<Integer> ds, ArrayList<List<Integer>> ans,int[] nums){
        ans.add(new ArrayList<>(ds));
        
        for(int i = ind;i<nums.length;i++){
            if(i!=ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            function(i+1,ds,ans,nums);
            ds.remove(ds.size()-1);
        }
    }
    

}