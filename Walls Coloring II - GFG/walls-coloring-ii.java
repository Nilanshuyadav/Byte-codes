//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		int n = costs.length, k = costs[0].length;
		
		if(k==1){
		    if(n==0)    return 0;
		    else if(n==1)   return costs[0][0];
		    else    return -1;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		List<int[]> al = new ArrayList<>();
		
		int[][] dp = new int[n][k];
		
		for(int ind=0; ind<k; ind++){
		    dp[0][ind] = costs[0][ind];
		    pq.add(new int[]{ind, costs[0][ind]});
		}    
		    
		int temp[] = {-1, -1}, min;
		boolean isTaken = false;
		for(int ind=1; ind<n; ind++){
		    for(int i=0; i<k; i++){
		        if(pq.peek()[0] == i){
		            temp = pq.remove();
		            isTaken = true;
		        }
		        
		        min = pq.peek()[1];
		        
		        if(isTaken){
		            pq.add(temp);
		            isTaken = false;
		        }
		        
		        dp[ind][i] = min + costs[ind][i];
		        
		        al.add(new int[]{i, dp[ind][i]});
		    }
		    
		    pq.clear();
		    for(int inx[] : al) pq.add(inx);
		    al.clear();
		}    
		
		int mini = Integer.MAX_VALUE;
		for(int ind=0; ind<k; ind++)
		    mini = Math.min(mini, dp[n-1][ind]);
		    
		return mini;    
	}
}