class Solution {
    Trie root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Trie();
        
        for(String st : words)
            insert(st);
        
        List<String> ans = new ArrayList();
        
        for(String st : words){
            if(isConcatenated(0,st) > 1)
                ans.add(st);
        }
        
        return ans;
    }
    
    public int isConcatenated(int ind, String st){
        int n = st.length();
        
        if(ind==n)
            return 0;
        
        int max = Integer.MIN_VALUE;
        Trie temp = root;
        char ch;
        for(int inx=ind; inx<n; inx++){
            ch = st.charAt(inx);
            
            if(!temp.contains(ch)){
                return max;
            }
            
            temp = temp.get(ch);
            
            if(temp.isEnd()){
                max = Math.max(max, 1 + isConcatenated(inx+1, st));
            }
        }
        
        return max;
    }
    
    public void insert(String st){
        int n = st.length();
        
        char ch;
        Trie temp = root;
        for(int ind=0; ind<n; ind++){
            ch = st.charAt(ind);
            
            if(!temp.contains(ch)){
                temp.add(ch, new Trie());
            }
            
            temp = temp.get(ch);
        }
        
        temp.setEnd();
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
        return arr[ch-'a']!=null;
    }
    
    public Trie get(char ch){
        return arr[ch-'a'];
    }
    
    public void add(char ch, Trie node){
        arr[ch-'a'] = node;
    }
    
    public void setEnd(){
        end = true;
    }
    
    public boolean isEnd(){
        return end;
    }
}