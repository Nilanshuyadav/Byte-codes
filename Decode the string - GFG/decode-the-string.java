//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        Stack<String> st = new Stack<>();
        
        int n = s.length();
        
        for(int ind=0; ind<n; ind++){
            if(s.charAt(ind)!=']') st.push(s.charAt(ind)+"");
            else{
                StringBuilder sb = new StringBuilder();
                
                while(st.size()>0 && st.peek().charAt(0)!='[') sb.append(st.pop());
                st.pop();
                
                StringBuilder times = new StringBuilder();
                while(st.size()>0 && st.peek().charAt(0)>='0' && st.peek().charAt(0)<='9') times.append(st.pop());
                
                int time = Integer.parseInt(times.reverse().toString());
                
                while(time-->0){
                    st.push(sb.toString());
                }
            }
        }
        
        StringBuilder ans = new StringBuilder("");
        
        while(!st.isEmpty()) ans.append(st.pop());
        
        return ans.reverse().toString();
    }
}