//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        long lar = Long.MIN_VALUE, slar = Long.MIN_VALUE, tlar = Long.MIN_VALUE;
        long small = Long.MAX_VALUE, ssmall = Long.MAX_VALUE;
        
        
        for(long ind : arr){
            if(lar<=ind){
                tlar = slar;
                slar = lar;
                lar = ind;
            }
            else if(slar<=ind){
                tlar = slar;
                slar = ind;
            }
            else if(tlar<=ind){
                tlar = ind;
            }
            
            
            if(ind<=small){
                ssmall = small;
                small = ind;
            }
            else if(ind<=ssmall){
                ssmall = ind;
            }
        }
        
        
        return Math.max(lar*slar*tlar, lar*small*ssmall);
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends