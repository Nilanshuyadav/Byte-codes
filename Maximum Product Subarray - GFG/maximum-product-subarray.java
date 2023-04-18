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
        long ans = Long.MIN_VALUE, curr_pro = 1;
        
        int odd_count = 0, first_negative=-1;
        long pro_till_first = 1;
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind] == 0){
                if(first_negative != -1 && curr_pro!=pro_till_first)
                    ans = Math.max(ans, curr_pro/pro_till_first);
                
                ans = Math.max(ans, 0);
                curr_pro = 1;
                first_negative = -1;
                odd_count = 0;
                pro_till_first = 1;
                
                continue;
            }
            
            if(arr[ind] < 0){
                if(first_negative == -1){
                    first_negative = ind;
                    pro_till_first = curr_pro*arr[ind];
                }
                
                odd_count++;
            }
            
            curr_pro *= arr[ind];
            ans = Math.max(ans, curr_pro);
        }
        
        if(first_negative != -1 && curr_pro!=pro_till_first)
            ans = Math.max(ans, curr_pro/pro_till_first);
        
        return ans;
    }
}