class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, n+1, k, new ArrayList<>(), ans);
        return ans;
    }
    
    public void solve(int ind, int n, int k, List<Integer> temp, List<List<Integer>> ans){
        if(ind==n){
            if(k==0)
                ans.add(new ArrayList<>(temp));
            return;
        } 
        
        if(k>0){
            temp.add(ind);
            solve(ind+1, n, k-1, temp, ans);
            temp.remove(temp.size()-1);
        }
        
        solve(ind+1, n, k, temp, ans);
    }
}