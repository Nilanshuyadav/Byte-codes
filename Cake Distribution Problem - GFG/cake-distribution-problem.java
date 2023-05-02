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
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int maxSweetness(int [] sweetness, int N, int K) {
	    long l = Integer.MAX_VALUE, h=0;
	    
	    for(int ind : sweetness){
	        l = Math.min(l, ind);
	        h += ind;
	    }
	    long m, ans=-1;
	    
	    while(l<=h){
	        m = l + (h-l)/2;
	        
	        if(canWe(sweetness, m, K)){
	            ans = Math.max(ans, m);
	            l=m+1;
	        }
	        else{
	            h=m-1;
	        }
	    }
	    
	    return (int)ans;
	}
	
	boolean canWe(int[] sweetness, long m, int k){
	    int cnt=0;
	    long sum = 0;
	    
	    for(int ind : sweetness){
	        sum += ind;
	        
	        if(sum>=m){
	            cnt++;
	            sum=0;
	        }
	    }
	    
	    return cnt>k;
	}
}