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
        PriorityQueue<Pair> pq = new PriorityQueue<>(new my_comparator());
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int ind=0; ind<=n; ind++){
            adj.add(new ArrayList<>());
        }
        
        for(int ind[] : edges){
            adj.get(ind[0]).add(new int[]{ind[1], ind[2]});
            adj.get(ind[1]).add(new int[]{ind[0], ind[2]});
        }
        
        List<Integer> al = new ArrayList<>();
        al.add(1);
        
        pq.add(new Pair(al, 1, 0));
        List<Integer> ans = new ArrayList<>();
        boolean found = false;
        
        int[] arr = new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1] = 0;
        
        while(!pq.isEmpty()){
            Pair temp = pq.remove();
            
            if(temp.node == n){
                found = true;
                ans = temp.al;
                break;
            }
            
            int node = temp.node;
            List<Integer> lst = temp.al;
            
            for(int[] inx : adj.get(node)){
                if(temp.wt+inx[1] < arr[inx[0]]){
                    lst.add(inx[0]);
                    pq.add(new Pair(new ArrayList<>(lst), inx[0], temp.wt+inx[1]));
                    lst.remove(lst.size()-1); 
                    arr[inx[0]] = temp.wt+inx[1];
                }
            }
        }
        
        if(found)
            return ans;
        
        ans.add(-1);    
        return ans;    
    }
}

class my_comparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p1.wt - p2.wt;
    }
}

class Pair{
    List<Integer> al;
    int node;
    int wt;
    public Pair(List<Integer> al, int node, int wt){
        this.al = al;
        this.node = node;
        this.wt = wt;
    }
}