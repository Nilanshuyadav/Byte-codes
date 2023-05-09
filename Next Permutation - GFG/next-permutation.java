//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        int index=N-1;
        
        List<Integer> ans = new ArrayList<>();
        
        while(index>0 && arr[index-1] >= arr[index]){
            index--;
        }
        
        if(index == 0){
            reverse(0, N-1, arr);
            
            for(int ind : arr){
                ans.add(ind);
            }
            
            return ans;
        }
        
        index--;
        
        int index2=N-1;
        
        while(arr[index] >= arr[index2]){
            index2--;
        }
        
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
        
        reverse(index+1, N-1, arr);
        
        for(int ind : arr){
            ans.add(ind);
        }
        
        return ans;
    }
    
    public static void reverse(int s, int e, int[] arr){
        int temp;
        while(s<e){
            temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            
            s++;
            e--;
        }
    }
}