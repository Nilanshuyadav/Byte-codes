class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        int n = queries.size();
        
        Map<String, List<Node>> adj = buildGraph(equations, values);
        double[] ans = new double[n];
        
        String s, d;
        
        for(int ind=0; ind<n; ind++){
            s = queries.get(ind).get(0);
            d = queries.get(ind).get(1);
            
            ans[ind] = solve(s, d, new HashSet<>(), adj);
        }
        
        return ans;        
    }
    
    public double solve(String s, String d, Set<String> vis, Map<String, List<Node>> adj){
        if(!adj.containsKey(s) || !adj.containsKey(d)){
            return -1.0;
        }
        if(s.equals(d)){
            return 1.0;
        }
        
        String next;
        double val, temp;
        
        vis.add(s);
        for(Node ind : adj.get(s)){
            next = ind.des;
            val = ind.val;
            
            if(!vis.contains(next)){
                temp = solve(next, d, vis, adj);
                
                if(temp > 0){
                    return temp * val;
                }
            }
        }
        
        return -1;
    }
    
    public Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, List<Node>> map = new HashMap<>();
        String s, d;
        double val;
        
        for(int ind=0; ind <equations.size(); ind++){
            s = equations.get(ind).get(0);
            d = equations.get(ind).get(1);
            val = values[ind];
            
            map.putIfAbsent(s, new ArrayList<>());
            map.putIfAbsent(d, new ArrayList<>());
            
            map.get(s).add(new Node(d, val));
            map.get(d).add(new Node(s, 1/val));
        }
        
        return map;
    }
}

class Node{
    String des;
    double val;
    
    public Node(String des, double val){
        this.des = des;
        this.val = val;
    }
}