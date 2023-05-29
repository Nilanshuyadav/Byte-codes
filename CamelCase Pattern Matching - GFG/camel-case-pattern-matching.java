//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        List<String> al = new ArrayList<>();
        StringBuilder sb;
        
        for(String st : Dictionary){
            sb = new StringBuilder("");
            
            for(int ind=0; ind<st.length(); ind++){
                char ch = st.charAt(ind);
                
                if('A' <= ch && ch<='Z'){
                    sb.append(ch);
                }
            }
            
            al.add(sb.toString());
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(int ind=0; ind<N; ind++){
            String st = al.get(ind);
            
            if(st.indexOf(Pattern) == 0){
                ans.add(Dictionary[ind]);
            }
        }
        
        if(ans.size() == 0){
            ans.add("-1");
            return ans;
        }
        
        Collections.sort(ans, (a,b) -> a.compareTo(b));
        
        return ans;
    }
}