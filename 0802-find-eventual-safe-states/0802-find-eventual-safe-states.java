class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Boolean[] arr = new Boolean[n];
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind]==null){
                solve(ind, graph, arr);
            }
        }
        
        List<Integer> al = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind]){
                al.add(ind);
            }
        }
        
        return al;
    }
    
    public boolean solve(int ind, int[][] graph, Boolean[] arr){
        if(arr[ind]!=null){
            return arr[ind];
        }
        
        boolean bool = true;
        arr[ind] = false;
        
        for(int inx : graph[ind]){
            bool = bool && solve(inx, graph, arr);
        }
        
        return arr[ind] = bool;
    }
}