class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Trie root = new Trie(), node;
        
        for(String st : cpdomains){
            int cnt=0;
            String sb = "";
            node = root;
            
            for(int ind=0; ind<st.length(); ind++){
                if(st.charAt(ind)==' '){
                    sb = "."+st.substring(ind+1);
                    cnt = Integer.valueOf(st.substring(0,ind));
                    break;
                }
            }
            
            StringBuilder temp = new StringBuilder("");
            
            for(int ind=sb.length()-1; 0<=ind; ind--){
                if(sb.charAt(ind)!='.'){
                    temp.append(sb.charAt(ind));
                    continue;
                }
                String st_ = temp.reverse().toString();
                temp.setLength(0);
                
                if(!node.contains(st_))
                    node.insert(st_);
                
                node = node.get(st_);
                node.add_count(cnt);
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(Map.Entry<String, Trie> entry : root.map.entrySet()){
            
            dfs(entry.getKey(), entry.getValue(), "", ans);
        }
        
        return ans;
    }
    
    public void dfs(String s1, Trie node, String s2, List<String> ans){
        String to_add = s1+s2;
        ans.add(String.valueOf(node.count)+" "+to_add);
        
        for(Map.Entry<String, Trie> entry : node.map.entrySet()){
            dfs(entry.getKey(), entry.getValue(), "."+to_add, ans);
        }
    }
}

class Trie{
    Map<String, Trie> map;
    int count;
    
    public Trie(){
        map = new HashMap<>();
        count = 0;
    }
    
    public boolean contains(String st){
        return map.containsKey(st);
    }
    
    public void insert(String st){
        map.put(st, new Trie());
    }
    
    public Trie get(String st){
        return map.get(st);
    }
    
    public void add_count(int n){
        count += n;
    }
}