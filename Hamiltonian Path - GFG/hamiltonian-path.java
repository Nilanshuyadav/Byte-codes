//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<=N; ind++) 
            adj.add(new ArrayList<>());
        
        for(ArrayList<Integer> temp : Edges){
            adj.get(temp.get(0)).add(temp.get(1));
            adj.get(temp.get(1)).add(temp.get(0));
        }
        
        boolean vis[] = new boolean[N+1];
        for(int ind=1; ind<=N; ind++){
            vis[ind] = true;
            List<Integer> al = new ArrayList<>();
            al.add(ind);
            if(dfs(ind, adj, vis, al, N)) 
                return true;
                
            vis[ind] = false;    
        }
        
        return false;        
    }
    
    public boolean dfs(int ind, List<List<Integer>> adj, boolean[] vis, List<Integer> al, int N){
        if(al.size() == N) return true;
        
        for(int inx : adj.get(ind)){
            if(!vis[inx]){
                vis[inx] = true;
                al.add(inx);
                
                if(dfs(inx, adj, vis, al,N)) return true;
                
                al.remove(al.size()-1);
                vis[inx] = false;
            }
        }
        
        return false;
    }
} 