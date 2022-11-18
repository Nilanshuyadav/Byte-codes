//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        List<List<Integer>> temp_adj = new ArrayList<>();
        
        for(int ind=0; ind<V; ind++)
            temp_adj.add(new ArrayList<>());
        
        int[] indegree = new int[V];    
        for(int ind=0; ind<V; ind++){
            for(int inx : adj.get(ind)){
                temp_adj.get(inx).add(ind);
                indegree[ind]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int ind=0; ind<V; ind++){
            if(indegree[ind] == 0)
                q.add(ind);
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int temp = q.remove();
            ans.add(temp);
            
            for(int inx : temp_adj.get(temp)){
                indegree[inx]--;
                if(indegree[inx] == 0)
                    q.add(inx);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}
