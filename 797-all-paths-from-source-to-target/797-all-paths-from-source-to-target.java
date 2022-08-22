class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ans = new ArrayList<>();
        
        function(graph,0,n,new ArrayList<>());
        
        return ans;
    }
    
    public void function(int[][] graph, int ind,int n,List<Integer> al){
        al.add(ind);
        
        if(ind == n-1){
            ans.add(new ArrayList<>(al));
            al.remove(al.size()-1);
            return;
        }
        
        for(int i : graph[ind])
            function(graph,i,n,al);
        
        al.remove(al.size()-1);
    }
}