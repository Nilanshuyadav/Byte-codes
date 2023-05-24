//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        // code here
        
        int total = 0, max=0;
        
        for(int ind : arr){
            total += ind;
            max = Math.max(max, ind);
        }
        
        int l=max, h=total, m, temp, min=total;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            temp = canWe(m, arr);
            
            if(temp<=D){
                min = Math.min(min, m);
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return min;
    }
    
    static int canWe(int m, int[] arr){
        int cnt=0, sum = 0;
        
        for(int ind : arr){
            sum += ind;
            
            if(m < sum){
                cnt++;
                sum = ind;
            }
        }
        
        return cnt+1;
    }
};