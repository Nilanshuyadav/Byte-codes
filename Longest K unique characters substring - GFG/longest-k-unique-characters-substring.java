//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        Set<Character> set = new HashSet<>();
        int n = s.length(), i=0, j=0, max=-1, arr[] = new int[26];
        char ch, ch2;
        
        for(i=0; i<n; i++){
            ch = s.charAt(i);
            set.add(ch);
            arr[ch-'a']++;
            
            while(set.size()>k){
                ch2 = s.charAt(j);
                
                arr[ch2-'a']--;
                
                if(arr[ch2-'a']==0){
                    set.remove(ch2);
                }
                
                j++;
            }
            
            if(set.size()==k){
                max = Math.max(max, i-j+1);
            }
        }
        
        return max;
    }
}