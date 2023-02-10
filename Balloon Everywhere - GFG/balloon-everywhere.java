//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        int[] arr = new int[26];
        int n = s.length();
        
        for(int ind=0; ind<n; ind++){
            arr[s.charAt(ind)-'a']++;
        }
        
        String st = "balloon";
        arr['l'-'a'] /= 2;
        arr['o'-'a'] /= 2;
        
        int min = Integer.MAX_VALUE;
        
        for(int ind=0; ind<7; ind++){
            min = Math.min(min, arr[st.charAt(ind)-'a']);
        }
        
        return min;
    }
}