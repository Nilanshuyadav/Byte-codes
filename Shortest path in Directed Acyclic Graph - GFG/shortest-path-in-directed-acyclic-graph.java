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
		List<List<List<Integer>>> adj = new ArrayList<>();
		
		for(int ind=0; ind<N; ind++)
		    adj.add(new ArrayList<>());
		
		for(int ind[] : edges){
		    List<Integer> al = new ArrayList<>();
		    al.add(ind[1]);
		    al.add(ind[2]);
		    adj.get(ind[0]).add(al);
		}
		
		int[] ans = new int[N];
		Arrays.fill(ans, Integer.MAX_VALUE);
		PriorityQueue<int[]> q = new PriorityQueue<>(new my_comparator());
		
		ans[0] = 0;
		q.add(new int[]{0,0});
		
		while(!q.isEmpty()){
		    int[] temp = q.remove();
		    
		    for(List<Integer> inx : adj.get(temp[0])){
		        if(temp[1]+inx.get(1) < ans[inx.get(0)]){
		            ans[inx.get(0)] = temp[1]+inx.get(1);
		            q.add(new int[]{inx.get(0), temp[1]+inx.get(1)});
		        }
		    }
		}
		
		for(int ind=0; ind<N; ind++){
		    if(ans[ind] == Integer.MAX_VALUE)
		        ans[ind] = -1;
		}
		
		return ans;
	}
}

class my_comparator implements Comparator<int[]>{
    public int compare(int[] ind1, int[] ind2){
        return ind1[1] - ind2[1];
    }
}