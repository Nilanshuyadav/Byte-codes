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
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
		int n = str.length(), i=0, j=n-1;
		
		int ans=0;
		
		while(i<=j){
		    if(str.charAt(i) != str.charAt(j)){
		        while(i<j && str.charAt(j)==str.charAt(j-1)){
		            j--;
		        }
		        j--;
		        
		        ans++;
		    }
		    else{
		        while(i<j && str.charAt(j)==str.charAt(j-1)){
		            j--;
		        }
		        j--;
		        
		        while(i<j && str.charAt(i)==str.charAt(i+1)){
		            i++;
		        }
		        i++;
		        
		        ans++;
		    }
		}
		
		return ans;
	}
}