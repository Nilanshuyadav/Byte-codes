//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] price = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            sln.stockBuySell(price, n);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void stockBuySell(int[] arr, int n) {
        int pre=0, ind=1;
        boolean found = false;
        
        while(ind < n){
            if(arr[ind-1] > arr[ind]){
                if(pre != ind-1){
                    found = true;
                    System.out.print("("+pre + " " + (ind-1)+")" +" ");
                }
                pre = ind;
            }
            
            ind++;
        }
        
        if(pre != ind-1){
            found = true;
            System.out.print("("+pre + " " + (ind-1)+")" +" ");
        }
        
        if(!found){
            System.out.println("No Profit");
        }
        else{
            System.out.println();
        }
    }
}