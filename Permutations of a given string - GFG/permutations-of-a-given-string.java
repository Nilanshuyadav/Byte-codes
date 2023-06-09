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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    Set<String> al;
    public List<String> find_permutation(String S) {
        // Code here
        al = new HashSet<>();
        
        int n = S.length();
        
        solve(0, S, n, new StringBuilder(""), new boolean[n]);
        
        List<String> ans = new ArrayList<>(al);
        Collections.sort(ans);
        
        return ans;
    }
    
    public void solve(int inx, String s, int n, StringBuilder sb, boolean[] vis){
        if(inx == n){
            al.add(sb.toString());
            
            return;
        }
        
        for(int ind=0; ind<n; ind++){
            if(!vis[ind]){
                vis[ind] = true;
                solve(inx+1, s, n, sb.append(s.charAt(ind)), vis);
                sb.deleteCharAt(sb.length()-1);
                vis[ind] = false;
            }
        }
    }
}