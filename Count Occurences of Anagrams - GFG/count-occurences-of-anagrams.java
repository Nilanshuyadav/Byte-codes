//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        int[] hash = new int[26], temp_hash = new int[26];
        
        int pat_length = pat.length(), txt_length = txt.length();
        
        for(int ind=0; ind<pat_length; ind++){
            hash[pat.charAt(ind)-'a']++;
        }
        
        int cnt=0;
        
        for(int ind=0; ind<txt_length; ind++){
            if(ind>=pat_length-1){
                temp_hash[txt.charAt(ind)-'a']++;
                
                if(ind>=pat_length)
                    temp_hash[txt.charAt(ind-pat_length)-'a']--;
                
                if(equal(hash, temp_hash))
                    cnt++;
            }
            else{
                temp_hash[txt.charAt(ind)-'a']++;
            }
        }
        
        return cnt;
    }
    
    boolean equal(int[] hash, int[] temp_hash){
        for(int ind=0; ind<26; ind++){
            if(hash[ind] != temp_hash[ind])
                return false;
        }
        
        return true;
    } 
}