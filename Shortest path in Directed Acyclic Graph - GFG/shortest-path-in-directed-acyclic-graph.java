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
		
		for(int ind=0; ind<N; ind++){
		    adj.add(new ArrayList<>());
		}
		
		for(int ind[] : edges){
		    adj.get(ind[0]).add(new int[]{ind[1], ind[2]});
		}
		
		int[] ans = new int[N];
		Arrays.fill(ans, (int)1e8);
		
		Queue<Integer> pq = new LinkedList<>();
		pq.add(0);
		ans[0] = 0;
		
		int temp, next, temp_dist;
		
		while(!pq.isEmpty()){
		    temp = pq.remove();
		    
		    
		    for(int ind[] : adj.get(temp)){
		        next = ind[0];
		        temp_dist = ind[1];
		        
		        if(ans[temp]+temp_dist < ans[next]){
		            ans[next] = ans[temp]+temp_dist;
		            pq.add(next);
		        }
		    }
		}
		
		for(int ind=0; ind<N; ind++){
		    if(ans[ind] == (int)1e8){
		        ans[ind] = -1;
		    }
		}
		
		return ans;
	}
}