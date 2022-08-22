class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        
        function(graph,0,new ArrayList<>());
        
        return ans;
    }
    
    public void function(int[][] graph, int ind,List<Integer> al){
        al.add(ind);
        
        if(ind == graph.length-1){
            ans.add(new ArrayList<>(al));
            al.remove(al.size()-1);
            return;
        }
        
        for(int i : graph[ind])
            function(graph,i,al);
        
        al.remove(al.size()-1);
    }
}