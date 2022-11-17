//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        
        for(int ind=0; ind<V; ind++){
            for(int inx : adj.get(ind)){
                indegree[inx]++;
            }
        }
        
        List<Integer> al = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int ind=0; ind<V; ind++)
            if(indegree[ind] == 0){
                q.add(ind);
            }
            
        while(!q.isEmpty()){
           int temp = q.remove();
           al.add(temp);
               
            for(int inx : adj.get(temp)){
                indegree[inx]--;
                if(indegree[inx]==0)
                    q.add(inx);
            }
        }
        
        return al.size()!=V;
    }
}