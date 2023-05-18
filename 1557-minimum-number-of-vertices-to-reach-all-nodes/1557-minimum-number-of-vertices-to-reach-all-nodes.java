class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        boolean[] inDegree = new boolean[n];
        
        for(int ind=0; ind<edges.size(); ind++){
            inDegree[edges.get(ind).get(1)] = true;
        }
        
        for(int ind=0; ind<n; ind++){
            if(!inDegree[ind]){
                ans.add(ind);
            }
        }
        
        return ans;
    }
}