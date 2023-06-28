class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++){
            adj.add(new ArrayList<>());
        }
        
        int u, v;
        double prob;
        
        for(int ind=0; ind<edges.length; ind++){
            u = edges[ind][0];
            v = edges[ind][1];
            prob = succProb[ind];
            
            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.prob >= b.prob ? -1 : 1);
        
        pq.add(new Pair(start, 1.0));
        
        double[] arr = new double[n];
        Pair temp;
        
        int to, curr;
        double pr;
        
        while(!pq.isEmpty()){
            temp = pq.remove();
            
            curr = temp.curr;
            prob = temp.prob;
            
            for(Pair tmp : adj.get(curr)){
                to = tmp.curr;
                pr = tmp.prob;
                
                if(arr[to] < prob*pr){
                    arr[to] = prob*pr;
                    pq.add(new Pair(to, arr[to]));
                }
            }
        }
        
        return arr[end];
    }
}

class Pair{
    int curr;
    double prob;
    
    public Pair(int curr, double prob){
        this.curr = curr;
        this.prob = prob;
    }
}