//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] parent, rank;
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        parent = new int[V];
        rank = new int[V];
        
        for(int id=0; id<V; id++)
            parent[id] = id;
        
        List<List<Integer>> ad = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(i!=j && adj.get(i).get(j)==1){
                    int from_par = findPar(i);
                    int to_par = findPar(j);
                    
                    if(from_par == to_par)
                        continue;
                    
                    union(from_par, to_par);    
                }
            }
        }
        
        int ans=0;
        
        for(int ind=0; ind<V; ind++)
            if(parent[ind] == ind)
                ans++;
                
        return ans;        
    }
    
    static void union(int from_par, int to_par){
        if(rank[from_par] > rank[to_par])
            parent[to_par] = from_par;
            
        else if(rank[to_par] > rank[from_par])
            parent[from_par] = to_par;
        
        else{
            parent[from_par] = to_par;
            rank[to_par]++;
        }
    }
    
    static int findPar(int ind){
        if(parent[ind] == ind)
            return ind;
        
        return parent[ind] = findPar(parent[ind]);    
    }
};