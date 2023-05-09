//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        int[] temp = new int[n];
        
        int count=0;
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind] < 0){
                count++;
            }
        }
        
        int pointer=count, neg=0;
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind] >= 0){
                temp[pointer++] = arr[ind];
            }
            else{
                temp[neg++] = arr[ind];
            }
        }
        
        neg=0;
        pointer = count;
        int ind=0;
        
        while(neg<count && pointer<n){
            if((ind&(1<<0)) == 0){
                arr[ind] = temp[pointer++];
            }    
            else{
                arr[ind] = temp[neg++];
            }
            
            ind++;
        }
        
        while(neg<count){
            arr[ind++] = temp[neg++];
        }
        
        while(pointer<n){
            arr[ind++] = temp[pointer++];
        }
        
        return;
    }
}