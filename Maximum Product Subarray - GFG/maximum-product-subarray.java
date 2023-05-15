//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long product=1, max_product=Long.MIN_VALUE, first_index=-1, first_index_product=0;
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind] == 0){
                if(first_index!=-1 && product!=(long)arr[(int)first_index]){
                    max_product = Math.max(max_product, product/first_index_product);
                }
                
                product = 1;
                first_index=-1;
                
                max_product = Math.max(max_product, 0);
                
                continue;
            }
            
            if(arr[ind] < 0){
                if(first_index==-1){
                    first_index = ind;
                    first_index_product = product*arr[ind];
                }
            }
            
            product *= arr[ind];
            
            max_product = Math.max(max_product, product);
        }
        
        if(first_index!=-1 && product!=(long)arr[(int)first_index]){
            max_product = Math.max(max_product, product/first_index_product);
        }
        
        return max_product;
    }
}