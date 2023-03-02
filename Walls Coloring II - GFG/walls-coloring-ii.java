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
		int[] min1=new int[]{-1,Integer.MAX_VALUE}, min2=new int[]{-1, Integer.MAX_VALUE};
		
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
		    
		    if(costs[0][ind] <= min1[1]){
		        min2[0] = min1[0];
		        min2[1] = min1[1];
		        
		        min1[0] = ind;
		        min1[1] = costs[0][ind];
		    }
		    else if(costs[0][ind] < min2[1]){
		        min2[0] = ind;
		        min2[1] = costs[0][ind];
		    }
		    
		  //  pq.add(new int[]{ind, costs[0][ind]});
		}    
		    
		int temp[] = {-1, -1}, min, temp_min1[]={-1, Integer.MAX_VALUE}, temp_min2[]={-1, Integer.MAX_VALUE};
		boolean isTaken = false;
		for(int ind=1; ind<n; ind++){
		    
		    temp_min1[1] = Integer.MAX_VALUE;
		    temp_min2[1] = Integer.MAX_VALUE;
		    
		    for(int i=0; i<k; i++){
		        if(min1[0] == i)
		            min = min2[1];
		        else
		            min = min1[1];
		            
		            
		        dp[ind][i] = min + costs[ind][i];        
		        
		        
		        
		        if(dp[ind][i] <= temp_min1[1]){
    		        temp_min2[0] = temp_min1[0];
    		        temp_min2[1] = temp_min1[1];
    		        
    		        temp_min1[0] = i;
    		        temp_min1[1] = dp[ind][i];
    		    }
    		    else if(dp[ind][i] < temp_min2[1]){
    		        temp_min2[0] = i;
    		        temp_min2[1] = dp[ind][i];
    		    }
    		    
		        
		      //  if(pq.peek()[0] == i){
		      //      temp = pq.remove();
		      //      isTaken = true;
		      //  }
		        
		      //  min = pq.peek()[1];
		        
		      //  if(isTaken){
		      //      pq.add(temp);
		      //      isTaken = false;
		      //  }
		        
		      //  dp[ind][i] = min + costs[ind][i];
		        
		      //  al.add(new int[]{i, dp[ind][i]});
		    }
		    
		    min1[0] = temp_min1[0];
		    min1[1] = temp_min1[1];
		    
		    min2[0] = temp_min2[0];
		    min2[1] = temp_min2[1];
		    
		  //  pq.clear();
		  //  for(int inx[] : al) pq.add(inx);
		  //  al.clear();
		}    
		
		int mini = Integer.MAX_VALUE;
		for(int ind=0; ind<k; ind++)
		    mini = Math.min(mini, dp[n-1][ind]);
		    
		return mini;    
	}
}