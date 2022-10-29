//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int ans=0;
        boolean[] vis = new boolean[V];

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new my_comparator());
        
        vis[0] = true;
        for(ArrayList<Integer> al : adj.get(0))
            pq.add(al);
            
        while(!pq.isEmpty()){
            ArrayList<Integer> temp = pq.remove();
            if(!vis[temp.get(0)]){
                ans += temp.get(1);
                vis[temp.get(0)] = true;
                
                for(ArrayList<Integer> al : adj.get(temp.get(0))){
                    if(vis[al.get(0)]) continue;
                    pq.add(al);
                }
            }
        }
        
        return ans;
    }
}

class my_comparator implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> al1, ArrayList<Integer> al2){
        return al1.get(1) - al2.get(1);
    }
}
