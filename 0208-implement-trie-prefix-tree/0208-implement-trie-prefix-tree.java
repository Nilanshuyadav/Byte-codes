class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length(), ch;
        TrieNode node = root;
        
        for(int ind=0; ind<n; ind++){
            ch = word.charAt(ind)-'a';
            
            if(node.arr[ch] == null){
                node.arr[ch] = new TrieNode();
            }
            
            node = node.arr[ch];
        }
        
        node.end = true;
    }
    
    public boolean search(String word) {
        int n = word.length(), ch;
        TrieNode node = root;
        
        for(int ind=0; ind<n; ind++){
            ch = word.charAt(ind)-'a';
            
            if(node.arr[ch] == null){
                return false;
            }
            
            node = node.arr[ch];
        }
        
        return node.end;
    }
    
    public boolean startsWith(String word) {
        int n = word.length(), ch;
        TrieNode node = root;
        
        for(int ind=0; ind<n; ind++){
            ch = word.charAt(ind)-'a';
            
            if(node.arr[ch] == null){
                return false;
            }
            
            node = node.arr[ch];
        }
        
        return true;
    }
}

class TrieNode{
    TrieNode[] arr;
    boolean end;
    
    public TrieNode(){
        arr = new TrieNode[26];
        end = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */