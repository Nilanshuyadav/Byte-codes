class Solution {
    long cost;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        List<List<Integer>> adj = new ArrayList<>();
        cost = 0;
        
        for(int ind=0; ind<=n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : roads){
            adj.get(ind[0]).add(ind[1]);
            adj.get(ind[1]).add(ind[0]);
        }
        
        solve(0, adj, -1, seats);
        
        return cost;
    }
    
    public long solve(int ind, List<List<Integer>> adj, int parent, int seats){
        long people = 1;
        
        for(int inx : adj.get(ind)){
            if(inx == parent)
                continue;
            people += solve(inx, adj, ind, seats);
        }
        
        if(ind != 0)
            cost += (people+seats-1)/seats;
        
        return people;
    }
}