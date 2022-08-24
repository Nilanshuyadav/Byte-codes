class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] it) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            if(i == headID) continue;
            adj.get(manager[i]).add(i);
        }
        
        return function(headID,it,adj);
    }
    
    public int function(int ind,int[] it, List<List<Integer>>adj){
        int max = 0;
        
        for(int i : adj.get(ind)){
            max = Math.max(max,function(i,it,adj));
        }
        return it[ind]+max;
    }
}