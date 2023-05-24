//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int K) {
        
        int n=nums.length, l=1, h=(int)1e8, m;
        int min=Integer.MAX_VALUE, temp;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            temp = canWe(m, nums);
            
            if(temp <= K){
                min = Math.min(min, m);
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    
    public static int canWe(int m, int[] nums){
        int sum = 0;
        
        for(int ind : nums){
            sum += Math.ceil((float)ind/m);
        }
        
        return sum;
    }
}