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
    public String FirstNonRepeating(String A)
    {
        // code here
        Map<Character, Integer> map = new LinkedHashMap<>();
        int n = A.length();
        char ch;
        
        StringBuilder sb = new StringBuilder("");
        boolean bool;
        
        for(int ind=0; ind<n; ind++){
            ch = A.charAt(ind);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            bool = false;
            
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() > 1)    continue;
                
                bool = true;    
                sb.append(entry.getKey());
                break;
            }
            
            if(!bool){
                sb.append('#');
            }
        
        }
        
        return sb.toString();
    }
}