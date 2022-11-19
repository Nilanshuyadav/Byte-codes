//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
	    List<List<int[]>> adj = new ArrayList<>();
	    
	    for(int ind=0; ind<N; ind++)
	        adj.add(new ArrayList<>());
	    
	    for(int ind[] : edges){
	        adj.get(ind[0]).add(new int[]{ind[1], ind[2]});
	    }
	    
	    int ans[] = new int[N];
	    Arrays.fill(ans, Integer.MAX_VALUE);
	    
	    Stack<Integer> st = new Stack<>();
	    boolean[] vis = new boolean[N];
	    findTopo(0, adj, st, vis);
	    
	    ans[0] = 0;
	    
	    while(!st.isEmpty()){
	        int temp = st.pop();
	        
	        for(int inx[] : adj.get(temp)){
	            if(ans[temp]+inx[1] < ans[inx[0]])
	                ans[inx[0]] = ans[temp]+inx[1];
	        }
	    }
	    
	    for(int ind=0; ind<N; ind++)
	        if(ans[ind] == Integer.MAX_VALUE)
	            ans[ind] = -1;
	            
	   return ans;         
	}
	
	public void findTopo(int ind, List<List<int[]>> adj, Stack<Integer> st, boolean[] vis){
	    vis[ind] = true;
	    for(int inx[] : adj.get(ind)){
	        if(!vis[inx[0]])
	            findTopo(inx[0], adj, st, vis);
	    }
	    
	    st.push(ind);
	}
}