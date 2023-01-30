//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution{
    int ans;
    public int countVertex(int N, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        ans=0;
        
        for(int ind=0; ind<=N; ind++)
            adj.add(new ArrayList<>());
            
        for(int ind[] : edges){
            adj.get(ind[0]).add(ind[1]);
            adj.get(ind[1]).add(ind[0]);
        }
        
        solve(1, adj, -1);
        return ans;
    }
    
    public boolean solve(int ind, List<List<Integer>> adj, int parent){
        boolean temp = false;
        
        for(int inx : adj.get(ind)){
            if(inx!=parent && !solve(inx, adj, ind))
                temp = true;
        }
        
        if(temp)
            ans++;
        return temp;    
    }
}

//{ Driver Code Starts.

// } Driver Code Ends