//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String removePair(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();        

        for(int ind=0; ind<s.length(); ind++)
        {
            char ch=s.charAt(ind);
            if(st.isEmpty())
            {
                st.push(ch);
            }
            else if(ch==st.peek()) 
            {
                st.pop();
            } 
            else 
            {
                st.push(ch);
            }
        }

        while(!st.isEmpty())
        {
             sb.append(st.pop());
        }
        return sb.length()==0 ? "-1" : sb.reverse().toString();

    }
}
        
