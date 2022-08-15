class Solution {
    class Pair {
        int i;
        int path;
        public Pair(int i, int path) {
            this.i = i;
            this.path = path;
        }
    }
    public int shortestPathLength(int[][] graph) {
        /*
        For each node currentNode, steps as key, visited as value
        boolean[currentNode][steps]
        */
        int n = graph.length;
        
        // 111....1, 1<< n - 1
        int allVisited = (1 << n) - 1;
        
        boolean[][] visited = new boolean[n][1 << n];
        Queue<Pair> q = new LinkedList<>();
        if (1 << 0 == allVisited) return 0;
        for (int i = 0; i < n; i++) {
            
            visited[i][1 << i] = true;   
            q.offer(new Pair(i, 1 << i));
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int[] edges = graph[p.i];
         
                for(int t: edges) {
                    int path = p.path | (1 << t);
                    if (path == allVisited) return step + 1;
                    if (!visited[t][path]) {
                        visited[t][path] = true;
                        q.offer(new Pair(t, path)); 
                    }                                    
                }
            }
            step++;
        }
        return step;
    }
}