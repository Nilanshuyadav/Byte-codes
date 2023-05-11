//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        // code here
        int sum = 0;
        int i=0, j=s.length()-1;
        char i_char, j_char, pre='*';
        
        while(i<=j){
            i_char = s.charAt(i);
            j_char = s.charAt(j);
            
            if(i_char!='?' && j_char!='?' && i_char!=j_char){
                return -1;
            }
            
            if(pre=='*' && (i_char!='?' || j_char!='?')){
                pre = i_char!='?' ? i_char : j_char;
            }
            else{
                if(i_char!='?' || j_char!='?'){
                    if(j_char!='?'){
                        i_char = j_char;
                    }
                    
                    sum += Math.abs(pre-i_char);
                    pre = i_char;
                }
            }
            
            i++;
            j--;
        }
        
        return sum*2;
        
    }
}
