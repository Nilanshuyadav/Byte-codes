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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    int parent[], rank[];
    int maxRemove(int[][] stones, int n) {
        // Code here
        int row=0, col=0;
        
        for(int ind[] : stones){
            row = Math.max(row, ind[0]);
            col = Math.max(col, ind[1]);
        }
        
        parent = new int[row+col+2];
        rank = new int[row+col+2];
        
        for(int ind=0; ind<row+col+2; ind++){
            parent[ind] = ind;
        }
        
        for(int ind[] : stones){
            int a = ind[0];
            int b = row+1+ind[1];
            
            union(a, b);
        }
        
        int component = 0;
        
        for(int ind=0; ind<row+col+2; ind++){
            if(parent[ind] == ind && rank[ind]!=0)
                component++;
        }
        
        return n-component;
    }
    
    public void union(int a, int b){
        int a_par = findPar(a);
        int b_par = findPar(b);
        
        if(a_par != b_par){
            if(rank[a_par]<rank[b_par])
                parent[a_par] = b_par;
            else if(rank[b_par]<rank[a_par])
                parent[b_par] = a_par;
            else{
                parent[a_par] = b_par;
                rank[b_par]++;
            }    
        }
    }
    
    public int findPar(int a){
        if(parent[a] == a)
            return a;
        return parent[a] = findPar(parent[a]);    
    }
};
