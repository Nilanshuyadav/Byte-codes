//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[N];
        
        for(int ind=0; ind<N; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : prerequisites){
            adj.get(ind[1]).add(ind[0]);
            indegree[ind[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int ind=0; ind<N; ind++)
            if(indegree[ind] == 0)
                q.add(ind);
            
        int cnt=0;        
        while(!q.isEmpty()){
            int temp = q.remove();
            cnt++;
            
            for(int inx : adj.get(temp)){
                indegree[inx]--;
                if(indegree[inx]==0)
                    q.add(inx);
            }
        }        
        
        return cnt==N;
    }
    
}