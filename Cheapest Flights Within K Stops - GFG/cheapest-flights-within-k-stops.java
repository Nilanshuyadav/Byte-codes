//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : flights){
            adj.get(ind[0]).add(new int[]{ind[1], ind[2]});
        }
        
        Queue<Pair> pq = new LinkedList<>();
        
        int[] arr = new int[n];
    
        pq.add(new Pair(0, src, 0));
        
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[src] = 0;
        
        while(!pq.isEmpty()){
            Pair temp = pq.remove();
            
            int temp_k = temp.k;
            
            if(temp_k>k)
                continue;
            
            int node = temp.ind;
            
            for(int[] ind : adj.get(node)){
                if(arr[ind[0]] > temp.dis+ind[1] && temp_k<=k){
                    arr[ind[0]] = temp.dis+ind[1];
                    pq.add(new Pair(temp_k+1, ind[0], arr[ind[0]]));
                }
            }
        }
        
        return arr[dst]==Integer.MAX_VALUE? -1 : arr[dst];
    }
}

class Pair{
    int k;
    int ind;
    int dis;
    public Pair(int k, int ind, int dis){
        this.k = k;
        this.ind = ind;
        this.dis = dis;
    }
}

class my_comparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p1.k - p2.k;
    }
}