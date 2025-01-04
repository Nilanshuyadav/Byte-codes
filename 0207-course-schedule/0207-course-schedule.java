class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i[] : prerequisites){
            degree[i[0]]++;
            adj.get(i[1]).add(i[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(degree[i] == 0) q.add(i);
        }

        int temp;
        while(!q.isEmpty()){
            temp = q.remove();

            for(int i : adj.get(temp)){
                degree[i]--;

                if(degree[i] == 0) q.add(i);
            }
        }

        for(int i : degree){
            if(i!=0) return false;
        }

        return true;
    }
}