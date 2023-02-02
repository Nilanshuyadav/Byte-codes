//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    long ans;
    public long largesSumCycle(int N, int Edge[]){
        boolean[] vis = new boolean[N], dfs_vis = new boolean[N];
        long[] arr = new long[N];
        ans = -1;
        
        for(int ind=0; ind<N; ind++){
            if(!vis[ind]){
                solve(ind, vis, dfs_vis, arr, 0, Edge);
            }
        }
        
        return ans;
    }
    
    public void solve(int ind, boolean[] vis, boolean[] dfs_vis, long[] arr, long sum, int[] Edge){
        if(dfs_vis[ind]){
            ans = Math.max(ans, sum - arr[ind]);
            return;
        }
        
        if(vis[ind])
            return;
        
        vis[ind] = true;
        dfs_vis[ind] = true;
        
        arr[ind] = sum;
        
        int to = Edge[ind];
        
        if(to == -1){
            dfs_vis[ind] = false;
            return;
        }
        
        solve(to, vis, dfs_vis, arr, sum+ind, Edge);
        
        dfs_vis[ind] = false;
        return;
    }
}