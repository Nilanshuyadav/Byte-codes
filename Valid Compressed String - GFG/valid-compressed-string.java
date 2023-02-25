//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static int checkCompressed(String S, String T) {
        int n = T.length(), s_len = S.length();
        
        int temp=0, number;
        char ch;
        StringBuilder num;
        
        for(int ind=0; ind<n; ind++){
            ch = T.charAt(ind);
            
            if('0'<=ch && ch<='9'){
                num = new StringBuilder("");
                
                while(ind<n && '0'<=T.charAt(ind) && T.charAt(ind)<='9'){
                    num.append(T.charAt(ind++));
                }
                
                number = Integer.valueOf(num.toString());
                
                if((temp+number)<s_len){
                    temp += number;
                    ch = S.charAt(temp);
                }
                else
                    return (ind==n&&(temp+number)==s_len)?1:0;
            }
        
            if(T.charAt(ind) != ch)
                return 0;
            
            temp++;
        }
        
        return 1;
    }
}