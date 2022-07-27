class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] color = new int[n];
        Arrays.fill(color,-1);
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i =0;i<n;i++){
            
            if(color[i] == -1){
                color[i] = 0;
                q.add(new Pair(i,-1));
                
                while(!q.isEmpty()){
                    Pair temp = q.remove();
                    
                    for(int j : graph[temp.val])
                    {
                        if(j == temp.parent) continue;
                        if(color[j] != -1){
                            if(color[j] == color[temp.val])return false;
                            else continue;
                        }
                        color[j] = color[temp.val] == 0? 1:0;
                        q.add(new Pair(j,temp.val));
                    }
                }
            }
        }
        
        return true;
    }
}

class Pair{
    int val;
    int parent;
    
    public Pair(int val,int parent){
        this.val = val;
        this.parent = parent;
    }
}