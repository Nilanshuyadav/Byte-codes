//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    int[] parent, rank;
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        parent = new int[V];
        rank = new int[V];
        
        for(int ind=0; ind<V; ind++){
            parent[ind] = ind;
            rank[ind] = 0;
        }
        
        int[] parent2 = new int[V];
        Arrays.fill(parent2, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int ind=0; ind<V; ind++){
            if(parent2[ind] == -1){
                parent2[ind] = ind;
                q.add(ind);
                
                while(!q.isEmpty()){
                    int temp = q.remove();
                    
                    for(int inx : adj.get(temp)){
                        if(parent2[temp] == inx) continue;
                        int temp_par = findPar(temp);
                        int inx_par = findPar(inx);
                        
                        if(temp_par == inx_par) return 1;
                        union(temp, inx, temp_par, inx_par);
                        q.add(inx);
                        parent2[inx] = temp;
                    }
                }
            }    
        }
        
        return 0;
    }
    
    public void union(int a, int b, int a_p, int b_p){
        if(rank[a_p] < rank[b_p]){
            parent[a_p] = b_p;
        }
        else if(rank[b_p] < rank[a_p]){
            parent[b_p] = a_p;
        }
        else{
            parent[b_p] = a_p;
            rank[a_p]++;
        }
    }
    
    public int findPar(int node){
        if(node == parent[node])
            return node;
            
        return parent[node] = findPar(parent[node]);    
    }
}

class Pair{
    int w;
    int s;
    int d;
    public Pair(int w, int s, int d){
        this.w = w;
        this.s = s;
        this.d = d;
    }
}

class my_comparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p1.w - p2.w;
    }
}