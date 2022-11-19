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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : edges){
            adj.get(ind[0]).add(ind[1]);
            adj.get(ind[1]).add(ind[0]);
        }
        
        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        ans[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(src);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                int temp = q.remove();
            
                for(int inx : adj.get(temp)){
                    if(ans[temp]+1 <  ans[inx]){
                        ans[inx] = ans[temp]+1;
                        q.add(inx);
                    }
                }    
            }
        }
        
        for(int ind=0; ind<n; ind++){
            if(ans[ind] == Integer.MAX_VALUE)
                ans[ind] = -1;
        }
        
        return ans;
    }
}