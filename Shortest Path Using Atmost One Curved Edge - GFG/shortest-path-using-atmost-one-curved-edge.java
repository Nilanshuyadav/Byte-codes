//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            int a = Integer.parseInt(S1[0]);
            int b = Integer.parseInt(S1[1]);
            
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
            
            for(int i=0; i<m; i++)
            {
                String S2[] = read.readLine().split(" ");
                int u = Integer.parseInt(S2[0]);
                int v = Integer.parseInt(S2[1]);
                int x = Integer.parseInt(S2[2]);
                int y = Integer.parseInt(S2[3]);
                
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(x);
                edge.add(y);
                
                edges.add(edge);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestPath(n,m,a,b,edges));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Pair{
//     int node;
//     int weight;
//     Pair(int node,int weight){
//         this.node=node;
//         this.weight=weight;
//     }
// }
// class pairforpq{
//     int dist;
//     int node;
//     pairforpq(int dist,int node){
//         this.dist=dist;
//         this.node=node;
//     }
// }
// class Solution {
//     int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
//         // code here
//         ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
//         ArrayList<int[]> curvedadj=new ArrayList<>();
//         for(int i=0;i<=n;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<m;i++){
//             adj.get(edges.get(i).get(0)).add(new Pair(edges.get(i).get(1),edges.get(i).get(2)));
//             adj.get(edges.get(i).get(1)).add(new Pair(edges.get(i).get(0),edges.get(i).get(2)));
//             curvedadj.add(new int[]{edges.get(i).get(0),edges.get(i).get(1),edges.get(i).get(3)});
//         }
//         int dist1[]=new int[n+1];
//         Arrays.fill(dist1,(int)1e9);
//         dist1[a]=0;
//         findshortestPath(adj,a,dist1);
//         int dist2[]=new int[n+1];
//         Arrays.fill(dist2,(int)1e9);
//         dist2[b]=0;
//         findshortestPath(adj,b,dist2);
//         int ans=dist1[b];
//         for(int[] curve:curvedadj){
//             int u=curve[0];
//             int v=curve[1];
//             int w=curve[2];
//             ans=Math.min(ans,Math.min(dist1[u]+dist2[v]+w,dist2[u]+dist1[v]+w));
//         }
//         if(ans>=1e9) return -1;
//         return ans;
//     }
//     void findshortestPath(ArrayList<ArrayList<Pair>> adj,int src,int[] dist){
//         PriorityQueue<pairforpq> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
//         pq.add(new pairforpq(0,src));
//         while(!pq.isEmpty()){
//             int currdist=pq.peek().dist;
//             int node=pq.peek().node;
//             pq.poll();
//             for(int i=0;i<adj.get(node).size();i++){
//                 int edgeWeight=adj.get(node).get(i).weight;
//                 int adjnode=adj.get(node).get(i).node;
//                 if(edgeWeight+currdist<dist[adjnode]){
//                     dist[adjnode]=edgeWeight+currdist;
//                     pq.add(new pairforpq(dist[adjnode],adjnode));
//                 }
//             }
//         }
//     }
// };

// *****************************************************************************************************8



//User function Template for Java

class Solution {
    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int ind=0; ind<=n; ind++)
            adj.add(new ArrayList<>());
            
        int x,y,w1,w2;
        
        for(ArrayList<Integer> edge : edges){
            x = edge.get(0);
            y = edge.get(1);
            w1 = edge.get(2);
            
            adj.get(x).add(new int[]{y, w1});
            adj.get(y).add(new int[]{x, w1});
        }    
        
        long[] diag_a = new long[n+1], diag_b = new long[n+1];
        
        Arrays.fill(diag_a, Integer.MAX_VALUE);
        Arrays.fill(diag_b, Integer.MAX_VALUE);
        
        diag(a, diag_a, adj);
        diag(b, diag_b, adj);
        
        if(diag_a[b] == Integer.MAX_VALUE) return -1;
        
        long min = diag_a[b];
        
        for(ArrayList<Integer> edge : edges){
            x = edge.get(0);
            y = edge.get(1);
            w2 = edge.get(3);
            
            min = Math.min(min, diag_a[x]+w2+diag_b[y]);
            min = Math.min(min, diag_a[y]+w2+diag_b[x]);
        }
        
        return min>=(int)1e9 ? -1 : (int)min;
    }
    
    static void diag(int s, long[] arr, List<List<int[]>> adj){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        pq.add(new int[]{s, 0});
        arr[s] = 0;
        
        int temp[], next, weight, ind, dis;
        
        while(!pq.isEmpty()){
            temp = pq.remove();
            
            ind = temp[0];
            dis = temp[1];
            
            for(int i[] : adj.get(ind)){
                next = i[0];
                weight = i[1];
                
                if(dis+weight < arr[next]){
                    arr[next] = dis+weight;
                    pq.add(new int[]{next, (int)arr[next]});
                }
            }
        }
    }
};