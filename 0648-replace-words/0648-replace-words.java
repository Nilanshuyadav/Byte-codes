class Solution {
    Trie root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        
        for(String str : dictionary){
            insertString(str);
        }
        
        int i=0, j=0;
        int n = sentence.length();
        StringBuilder sb = new StringBuilder("");
        
        while(i<n){
            while(i<n && sentence.charAt(i)!=' '){
                i++;
            }    
            
            sb.append(findRoot(sentence.substring(j, i), i-j) + " ");
            j = ++i;
        }
        
        return sb.substring(0, sb.length()-1);
    }
    
    public String findRoot(String str, int n){
        char ch;
        Trie node = root;
        
        for(int i=0; i<n; i++){
            ch = str.charAt(i);
            
            if(!node.contains(ch)){
                return str;
            }    
            else{
                node = node.get(ch);
                
                if(node.isEnd()){
                    return str.substring(0, i+1);
                }
            }
        }
        
        return str;
    }
    
    public void insertString(String str){
        int n = str.length();
        char ch;
        
        Trie node = root;
        
        for(int i=0; i<n; i++){
            ch = str.charAt(i);
            
            if(!node.contains(ch)){
                node.addNode(ch);
            }    
            
            node = node.get(ch);
        }
        
        node.setEnd();
    }
}

class Trie{
    Trie[] arr;
    boolean isEnd;
    
    public Trie(){
        arr = new Trie[26];
        isEnd = false;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean contains(char ch){
        return arr[ch-'a']!=null;
    }
    
    public Trie get(char ch){
        return arr[ch-'a'];
    }
    
    public void addNode(char ch){
        arr[ch-'a'] = new Trie();
    }
}