class Solution {
    List<List<Integer>> al;
    
    public List<List<Integer>> combine(int n, int k) {
        al = new ArrayList<>();
        
        solve(n, k, new ArrayList<>());
        
        return al;
    }
    
    public void solve(int ind, int k, List<Integer> temp){
        if(ind==0 || k==0 || ind<k){
            if(k==0) al.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(ind);
        if(k>0) solve(ind-1, k-1, temp);
        
        temp.remove(temp.size()-1);
        solve(ind-1, k, temp);
    } 
}