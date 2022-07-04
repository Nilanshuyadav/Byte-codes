class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        
        function(al,new ArrayList<Integer>(),ans);
        return ans;
    }
    
    public void function(ArrayList<Integer> al, ArrayList<Integer> ds, List<List<Integer>> ans){
        int n = al.size();
        
        if(n <= 0){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        
        for(int i = 0;i<n;i++){
            ds.add(al.remove(i));
            function(al,ds,ans);
            al.add(i,ds.remove(ds.size()-1));
        }
        
    }
}