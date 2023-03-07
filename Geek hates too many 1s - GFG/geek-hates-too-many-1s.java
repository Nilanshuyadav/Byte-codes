//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        int cnt=0;
        
        for(int ind=0; ind<sb.length(); ind++){
            if(sb.charAt(ind) == '1')   cnt++;
            else    cnt=0;
            
            if(cnt>=3){
                sb.setCharAt(ind, '0');
                cnt=0;
            }
        }
        
        return Integer.parseInt(sb.toString(), 2);
    }
}
        
