//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        long product = 1;
        int zero = 0;
        for(int ind : nums){
            if(ind==0){
                zero = Math.min(2, ++zero);
            }
            else{
                product *= ind;
            }
        }
            
        long[] ans = new long[n];
        
        for(int ind=0; ind<n; ind++){
            if(zero>0){
                if(nums[ind]!=0 || zero>1)
                    ans[ind] = 0;
                else 
                    ans[ind] = product;   
            }
            else{
                ans[ind] = product/nums[ind];
            }
            
        }
        
        return ans;
	} 
} 
