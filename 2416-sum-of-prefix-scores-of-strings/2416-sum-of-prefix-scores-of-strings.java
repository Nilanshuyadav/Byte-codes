class Node{
    Node list[];
    int cnt;
    public Node(){
        list = new Node[26];
        cnt=0;
    }

    public boolean containsKey(char ch){
        return list[ch-'a']!=null;
    }

    public void put(char ch, Node node){
        list[ch-'a'] = node;
    }

    public Node get(char ch){
        return list[ch-'a'];
    }

    public void increment_cnt(){
        cnt++;
    }

    public int get_cnt(){
        return cnt;
    }
}

class Trie{
    Node root;
    public Trie(){
        root = new Node();
    }

    public void insert(String st){
        Node node = root;
        for(int ind=0; ind<st.length(); ind++){
            char ch = st.charAt(ind);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increment_cnt();
        }
    }

    public int count_prefix(String st){
        Node node = root;
        int sum=0;
        for(int ind=0; ind<st.length(); ind++){
            char ch = st.charAt(ind);
            node = node.get(ch);
            sum += node.get_cnt();
        }

        return sum;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int ans[] = new int[words.length], k=0, w_n=words.length;

        for(int ind=0; ind<w_n; ind++){
            trie.insert(words[ind]);
        }

        for(String st : words){

            ans[k++] = trie.count_prefix(st);
        }

        return ans;
    }
}