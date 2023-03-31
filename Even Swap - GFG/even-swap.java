//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
		List<Integer> al = new ArrayList<>();
		boolean even = (arr[0]&1) !=  0? false : true;
		int[] b = new int[n];
		int k=0;
		
		for(int ind=0; ind<n; ind++){
		    if(even){
		        if((arr[ind]&1) != 0){
		            Collections.sort(al, Collections.reverseOrder());
		            
		            for(int inx : al){
		                b[k++] = inx;
		            }
		            
		            al.clear();
		            
		            even = false;
		        }
		                
		    }
		    else{
		        if((arr[ind]&1) == 0){
		            Collections.sort(al, Collections.reverseOrder());
		            
		            for(int inx : al){
		                b[k++] = inx;
		            }
		            
		            al.clear();
		            
		            even = true;
		        }
		    }
		    
		    al.add(arr[ind]);
		}
		
		Collections.sort(al, Collections.reverseOrder());
		
		for(int inx : al){
		    b[k++] = inx;
		}
		
		return b;
	}
	
}