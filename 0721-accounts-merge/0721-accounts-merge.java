class Solution {
    int[] parent, rank;
    
    public void union(int a, int b){
        int par_a = findPar(a), par_b = findPar(b);
        
        if(par_a != par_b){
            if(rank[par_a] > rank[par_b]){
                parent[par_b] = par_a; 
            }
            else if(rank[par_a] < rank[par_b]){
                parent[par_a] = par_b;
            }
            else{
                parent[par_a] = par_b;
                rank[par_b]++;
            }
        }
    }
    
    public int findPar(int a){
        if(parent[a] == a){
            return a;
        }
        
        return parent[a] = findPar(parent[a]);
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int i=-1, size=accounts.size();
        
        parent = new int[size];
        rank = new int[size];
        
        for(int ind=0; ind<size; ind++){
            parent[ind] = ind;
        }
        
        String acc;
        
        for(List<String> al : accounts){
            i++;
            
            for(int ind=1; ind<al.size(); ind++){
                acc = al.get(ind);
                
                if(map.containsKey(acc)){
                    union(map.get(acc), i);
                }
                else{
                    map.put(acc, i);
                }
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        
        Map<Integer, List<String>> map2 = new HashMap<>();
        int ul_par;
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            ul_par = findPar(entry.getValue());
            
            map2.putIfAbsent(ul_par, new ArrayList<>());
            
            map2.get(ul_par).add(entry.getKey());
        }
        
        for(Map.Entry<Integer, List<String>> entry : map2.entrySet()){
            Collections.sort(entry.getValue());
            entry.getValue().add(0, accounts.get(entry.getKey()).get(0));
            
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}