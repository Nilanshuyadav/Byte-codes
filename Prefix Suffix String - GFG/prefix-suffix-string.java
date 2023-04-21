//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    Trie root;
    public int prefixSuffixString(String s1[],String s2[])
    {
        int cnt=0;
        root = new Trie();
        
        for(String s : s1){
            insert(s);
            
            StringBuilder sb = new StringBuilder(s);
            insert(sb.reverse().toString());
        }
        
        for(String s : s2){
            if(check(s)){
                cnt++;
            }
            else{
                StringBuilder sb = new StringBuilder(s);
                
                if(check(sb.reverse().toString())){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public boolean check(String s){
        Trie node = root;
        int n = s.length();
        char ch;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(!node.contains(ch)){
                return false;
            }
            
            node = node.get(ch);
        }
        
        return true;
    }
    
    public void insert(String s){
        Trie node = root;
        int n = s.length();
        char ch;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            if(!node.contains(ch)){
                node.add(ch);
            }
            
            node = node.get(ch);
        }
        
        node.setEnd();
    }
}

class Trie{
    Trie[] arr;
    boolean end;
    
    public Trie(){
        arr = new Trie[26];
        end = false;
    }
    
    public boolean contains(char ch){
        return arr[ch-'a'] != null;
    }
    
    public Trie get(char ch){
        return arr[ch-'a'];
    }
    
    public void add(char ch){
        arr[ch-'a'] = new Trie();
    }
    
    public boolean isEnd(){
        return end;
    }
    
    public void setEnd(){
        end = true;
    }
}