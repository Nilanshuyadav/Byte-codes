//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String s)
    {
        // code here
        int[] fre = new int[26];
        
        int n = s.length();
        Queue<Character> q = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder("");
        char temp, ch;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            fre[ch-'a']++;
            q.add(ch);
            
            while(!q.isEmpty()){
                temp = q.peek();
                
                if(fre[temp-'a'] == 1){
                    sb.append(temp);
                    break;
                }
                else{
                    q.remove();
                }
            }
            
            if(q.isEmpty()){
                sb.append('#');
            }
        }
        
        return sb.toString();
    }
}