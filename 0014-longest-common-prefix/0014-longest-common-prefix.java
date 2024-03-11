class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Trie root = new Trie();
        char ch;
        Trie node = root;
        
        for(int ind=0; ind<strs[0].length(); ind++){
            ch = strs[0].charAt(ind);
            
            if(!node.contains(ch)){
                node.add(ch);        
            }
            
            node = node.get(ch);
        }
        
        int index=0, min = 201;
        
        for(String s : strs){
            node = root;
            n = s.length();
            index = 0;
            
            for(int ind=0; ind<n; ind++){
                ch = s.charAt(ind);
                
                if(!node.contains(ch)){
                    index = ind;
                    break;
                }
                
                node = node.get(ch);
                
                if(ind == n-1){
                    index = n;
                }
            }
            
            min = Math.min(min, index);
        }
        
        return strs[0].substring(0, min);
    }
}

class Trie{
    Trie[] cha;
    boolean end;
    
    public Trie(){
        cha = new Trie[26];
        end = false;
    }
    
    public boolean contains(char ch){
        return cha[ch-'a']!=null;
    }
    
    public void add(char ch){
        cha[ch-'a'] = new Trie();
    }
    
    public Trie get(char ch){
        return cha[ch-'a'];
    }
    
}