class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        
        function(0,k,n,new ArrayList<>());
        return ans;
    }
    
    public void function(int ind, int k, int n,List<Integer> al){
        if(k==0){if(n==0)ans.add(new ArrayList<>(al)); return;}
        for(int i = ind+1;i<=9;i++){
            if(n-i>=0){
                al.add(i);
                function(i,k-1,n-i,al);
                al.remove(al.size()-1);
            }    
            else return; 
        }
    }
}