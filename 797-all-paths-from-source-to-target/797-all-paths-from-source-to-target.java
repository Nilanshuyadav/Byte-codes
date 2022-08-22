class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ans = new ArrayList<>();
        
        List<Integer> al = new ArrayList<>();
        al.add(0);
        function(graph,0,n,al);
        
        return ans;
    }
    
    public void function(int[][] graph, int ind,int n,List<Integer> al){
        for(int i : graph[ind]){
            if(i == n-1){
                al.add(i);
                ans.add(new ArrayList<>(al));
                al.remove(al.size()-1);
                continue;
            }
            else{
                al.add(i);
                function(graph,i,n,al);
                al.remove(al.size()-1);
            }
        }
    }
}