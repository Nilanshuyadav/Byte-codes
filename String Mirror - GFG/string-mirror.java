//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        if(str.length()>=2 && str.charAt(0)==str.charAt(1)){
            return ""+str.charAt(0)+str.charAt(0);
        }
        
        StringBuilder sb = new StringBuilder("");
        
        sb.append(str.charAt(0));
        
        for(int ind=1; ind<str.length(); ind++){
            char pre = str.charAt(ind-1), curr = str.charAt(ind);
            if(pre>=curr){
                sb.append(curr);
            }
            else{
                break;
            }
        }
        
        return sb.toString()+sb.reverse().toString();
    }
}
        
