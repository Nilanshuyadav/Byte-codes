//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


//User function Template for Java




class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        int floor, ceil;
        
        Arrays.sort(arr);
        
        floor = Floor(0, n-1, arr, x);
        ceil = Floor(0, n-1, arr, x);
        
        Pair ans = new Pair();
        
        if(ceil == n){
            ans.ceil = -1;
        }
        else{
            ans.ceil = arr[ceil];
        }
        
        if(floor == 0){
            if(arr[floor] == x){
                ans.floor = x;
            }
            else{
                ans.floor = -1;
            }
        }
        else{
            if(floor!=n && arr[floor] == x){
                ans.floor = x;
            }
            else{
                ans.floor = arr[floor-1];
            }
        }
        
        return ans;
    }
    
    int Floor(int l, int h, int[] arr, int target){
        int m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(arr[m] == target){
                return m;
            }
            else if(arr[m] < target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return h+1;
    }
}

