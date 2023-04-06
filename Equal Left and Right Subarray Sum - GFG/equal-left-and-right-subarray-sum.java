//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int [] A = new int[N];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++)
				A[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			System.out.println(ob.equalSum(A, N));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int equalSum(int [] A, int N) {
		int left_sum=0, right_sum=0;
		
		for(int ind : A){
		    right_sum += ind;
		}
		
		for(int ind=0; ind<N; ind++){
		    right_sum -= A[ind];
		    
		    if(left_sum == right_sum){
		        return ind+1;
		    }
		    
		    left_sum += A[ind];
		}
		
		return -1;
	}
}