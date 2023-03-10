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
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(arr);
        int n = arr.length, toCheck;
        
        for(int ind=0; ind<n-3; ind++){
            
            for(int i=ind+1; i<n-2; i++){
                toCheck = k-arr[ind]-arr[i];
                
                int l=i+1, h=n-1;
                
                while(l<h){
                    if(arr[l]+arr[h] == toCheck){
                        ArrayList<Integer> temp = new ArrayList<>();
                        
                        temp.add(arr[ind]);
                        temp.add(arr[i]);
                        temp.add(arr[l]);
                        temp.add(arr[h]);
                        
                        ans.add(temp);
                        
                        while(l<h && arr[l]==arr[l+1]) l++;
                        while(l<h && arr[h]==arr[h-1]) h--;
                        
                        l++;
                        h--;
                    }
                    else if(arr[l]+arr[h] < toCheck){
                        while(l<h && arr[l]==arr[l+1]) l++;
                        l++;
                    }
                    else{
                        while(l<h && arr[h]==arr[h-1]) h--;
                        h--;
                    }
                }
                
                while(i<n-2 && arr[i]==arr[i+1]) i++;
            }
            
            while(ind<n-3 && arr[ind]==arr[ind+1]) ind++;
        }
        
        return ans;
    }
}