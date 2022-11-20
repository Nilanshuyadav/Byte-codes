//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        int[] parent = new int[n+1], arr = new int[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new my_comparator());
        
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int ind=0; ind<=n; ind++){
            adj.add(new ArrayList<>());
            parent[ind] = ind;
            arr[ind] = Integer.MAX_VALUE;
        }
        
        for(int ind[] : edges){
            adj.get(ind[0]).add(new int[]{ind[1], ind[2]});
            adj.get(ind[1]).add(new int[]{ind[0], ind[2]});
        }
        
        
        parent[1] = 1;
        arr[1] = 0;
        
        pq.add(new Pair(1,0));
        
        while(!pq.isEmpty()){
            Pair temp = pq.remove();
            
            int node = temp.node;
            int wt = temp.wt;
            
            for(int[] inx : adj.get(node)){
                if(wt+inx[1] < arr[inx[0]]){
                    parent[inx[0]] = node;
                    arr[inx[0]] = wt+inx[1];
                    
                    pq.add(new Pair(inx[0], arr[inx[0]]));
                }
            }
        }
        
        if(parent[n] == n){
            return new ArrayList<>(Arrays.asList(-1));
        }
        
        List<Integer> ans = new ArrayList<>();
        ans.add(n);
        int temp = n;
        
        while(temp != 1){
            ans.add(0,parent[temp]);
            temp = parent[temp];
        }
        
        return ans;
    }
}

class my_comparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p1.wt - p2.wt;
    }
}

class Pair{
    int node;
    int wt;
    public Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}