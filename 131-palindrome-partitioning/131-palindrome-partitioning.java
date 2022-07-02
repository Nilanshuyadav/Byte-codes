class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        function(0,s.length(),s,new ArrayList<String>(),ans);
        
        return ans;
    }
    
    public void function(int ind,int N,String s,ArrayList<String> ds, List<List<String>> ans){
        if(ind == N){
            ans.add(new ArrayList<String>(ds));
            return;
        }
        
        for(int i = ind;i<N;i++){
            
            if(isPalindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                function(i+1,N,s,ds,ans);
                ds.remove(ds.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s,int start, int end){
        while(start <= end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        
        return true;
    }
}