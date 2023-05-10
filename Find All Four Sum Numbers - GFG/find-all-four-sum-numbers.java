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
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(arr);
        int n = arr.length;
        
        int i, j, sum, toFind;
        
        for(int a=0; a<n-3; a++){
            for(int b=a+1; b<n-2; b++){
                toFind = k-arr[a]-arr[b];
                
                i = b+1;
                j = n-1;
                
                while(i<j){
                    sum = arr[i]+arr[j];
                    
                    if(sum == toFind){
                        ans.add(new ArrayList<>(Arrays.asList(arr[a], arr[b], arr[i], arr[j])));
                        
                        while(i<j && arr[i]==arr[i+1]) i++;
                        while(i<j && arr[j]==arr[j-1]) j--;
                        
                        i++;
                        j--;
                    }
                    else if(sum < toFind){
                        i++;
                    }
                    else{
                        j--;
                    }
                }
                
                while(b<n-2 && arr[b]==arr[b+1]) b++;
            }
            
            while(a<n-3 && arr[a]==arr[a+1]) a++;
        }
        
        return ans;
    }
}