//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		Stack<Integer> st_pre = new Stack<>(), st_suff = new Stack<>();
		int n = arr.length;
		st_pre.add(-1);
		st_suff.add(n);
		
		int[] pre = new int[n], suff = new int[n];
		
		for(int i=0, j=n-1; i<n; i++, j--){
		    while(st_pre.size()>1 && arr[st_pre.peek()]>=arr[i]){
		        st_pre.pop();
		    }
		    
		    if(st_pre.size()==1){
		        pre[i] = -1;
		    }
		    else{
		       pre[i] = st_pre.peek(); 
		    }
		    
		    st_pre.add(i);
		    
		    while(st_suff.size()>1 && arr[j]<=arr[st_suff.peek()]){
		        st_suff.pop();
		    }      
		    
		    if(st_suff.size()==1){
		        suff[j] = n;
		    }
		    else{
		        suff[j] = st_suff.peek();
		    }
		    
		    st_suff.add(j);
		}
		
		int[] ans = new int[n];
		
		for(int ind=0; ind<n; ind++){
		    if(pre[ind]==-1 && suff[ind]==n){
		        ans[ind] = -1;
		    }
		    else if(pre[ind]==-1){
		        ans[ind] = suff[ind];
		    }
		    else if(suff[ind]==n){
		        ans[ind] = pre[ind];
		    }
		    else if(ind-pre[ind] != suff[ind]-ind){
		        ans[ind] = (ind-pre[ind]) > (suff[ind]-ind) ? suff[ind] : pre[ind];
		    }
		    else if(arr[pre[ind]] != arr[suff[ind]]){
		        ans[ind] = arr[pre[ind]] > arr[suff[ind]] ? suff[ind] : pre[ind];
		    }
		    else{
		        ans[ind] =  pre[ind];
		    }
		}
		
		return ans;
	}
}