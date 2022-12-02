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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    int[] parent, rank;
    public int Solve(int n, int[][] edge) {
        // Code here
        int m = edge.length;
        if(m < n-1)
            return -1;
            
        parent = new int[n];
        rank = new int[n];
        
        for(int ind=0; ind<n; ind++)
            parent[ind] = ind;
            
        for(int ind[] : edge){
            int from_par = findPar(ind[0]);
            int to_par = findPar(ind[1]);
            
            if(from_par == to_par)
                continue;
            
            union(from_par, to_par);    
        }    
        
        int total = 0;
        for(int ind=0; ind<n; ind++)
            if(parent[ind] == ind)
                total++;
                
        return total-1;        
    }
    
    public void union(int from_par, int to_par){
        if(rank[from_par] > rank[to_par])
            parent[to_par] = from_par;
            
        else if(rank[from_par] < rank[to_par])
            parent[from_par] = to_par;
            
        else{
            parent[from_par] = to_par;
            rank[to_par]++;
        }    
    }
    
    public int findPar(int ind){
        if(parent[ind] == ind)
            return ind;
        
        return parent[ind] = findPar(parent[ind]);    
    }
}