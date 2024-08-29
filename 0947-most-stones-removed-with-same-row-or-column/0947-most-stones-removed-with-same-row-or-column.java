class Solution {
    int[] rank, parent;
    public int removeStones(int[][] stones){
        int n = stones.length; 
        rank = new int[20002];
        parent = new int[20002];

        for(int ind=0; ind<20002; ind++){
            parent[ind] = ind;
        }

        for(int ind[] : stones){
            int r = ind[0];
            int c = 10001+ind[1];
            union(r,c);
        }

        Set<Integer> set = new HashSet<>();

        for(int ind[] : stones){
            set.add(findPar(ind[0]));
        }

        return n-set.size();
    }

    public int findPar(int a){
        if(parent[a] == a){
            return a;
        }

        return parent[a] = findPar(parent[a]);
    }

    public void union(int a, int b){
        int a_par = findPar(a);
        int b_par = findPar(b);

        if(a_par!=b_par){
            if(rank[a_par] < rank[b_par]){
            parent[a_par] = parent[b_par];
            }
            else if(rank[a_par] > rank[b_par]){
                parent[b_par] = parent[a_par];
            }
            else{
                parent[b_par] = parent[a_par];
                rank[a_par]++;
            }
        }
    }
}