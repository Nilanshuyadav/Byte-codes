class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] visited = new boolean[n][1<<n];
        
        int allVisited = (1<<n) -1;
        
        if(n==1) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            visited[i][1<<i] = true;
            q.add(new Pair(i,1<<i));
        }
        
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.remove();
                for(int edges : graph[p.ind]){
                    int temp = p.path | (1<<edges);
                    
                    if(temp == allVisited) return ++step;
                    if(!visited[edges][temp]){
                        visited[edges][temp] = true;
                        q.add(new Pair(edges,temp));
                    }
                }
            }
            step++;
        }
        
        return step;
    }
}

class Pair{
    int ind;
    int path;
    public Pair(int ind,int path){
        this.ind = ind;
        this.path = path;
    }
}