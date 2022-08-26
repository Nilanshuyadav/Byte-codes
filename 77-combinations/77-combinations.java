class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        function(1,n,k,new ArrayList<Integer>());
        return ans;
    }
    
    public void function(int ind, int n, int k, List<Integer> al){
        if(al.size() == k){
            ans.add(new ArrayList(al));
            return;
        }
        
       for(int i=ind;i<=n;i++){
           al.add(i);
           function(i+1,n,k,al);
           al.remove(al.size()-1);
       }
    }
}