//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    Trie root;
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        // code here
        int m = str.length();
        
        if(k>m){
            return 0;
        }
        
        root = new Trie();
        
        for(String st : arr){
            insert(st);
        }
        
        char ch;
        Trie node = root;
        
        for(int ind=0; ind<k; ind++){
            ch = str.charAt(ind);
            
            if(node.contains(ch)){
                node = node.get(ch);
            }    
            else{
                return 0;
            }
        }
        
        return node.cnt-1;
    }
    
    public void insert(String st){
        Trie node = root;
        int n = st.length();
        
        char ch;
        for(int ind=0; ind<n; ind++){
            ch = st.charAt(ind);
            
            if(!node.contains(ch)){
                node.add(ch);
            }
            
            node = node.get(ch);
        }
    }
}

class Trie{
    Trie[] arr = new Trie[26];
    int cnt;
    
    public Trie(){
        cnt = 0;
    }
    
    public boolean contains(char ch){
        return arr[ch-'a'] != null;
    }
    
    public void add(char ch){
        arr[ch-'a'] = new Trie();
    }
    
    public Trie get(char ch){
        Trie temp = arr[ch-'a'];
        
        temp.cnt++;
        return temp;
    }
}