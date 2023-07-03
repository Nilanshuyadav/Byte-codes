//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int ans = 0;
        
        int[] min = new int[n], max = new int[n];
        
        min[0] = arr[0];
        max[n-1] = arr[n-1];
        for(int i=1; i<n; i++){
            min[i] = Math.min(min[i-1], arr[i]);
        }
        
        for(int i=n-2; i>=0; i--){
            max[i] = Math.max(max[i+1], arr[i]);
        }
        
        int j=0, i=0;
        
        while(i<n && j<n){
            if(min[i] <= max[j]){
                ans = Math.max(ans, j-i);
                j++;
            }    
            else{
                i++;
            }
        }
        
        return ans;
    }
}