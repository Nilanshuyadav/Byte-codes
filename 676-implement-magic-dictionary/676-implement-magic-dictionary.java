class MagicDictionary {

    List<String> al;
    public MagicDictionary() {
        al = new ArrayList<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s: dictionary)
            al.add(s);
    }
    
    public boolean search(String searchWord) {
        for(String st : al){
            StringBuilder sb = new StringBuilder(st);
            StringBuilder searchword = new StringBuilder(searchWord);
            
            if(sb.length()!=searchword.length()) continue;
            int cnt=0;
            
            for(int ind=0; ind<sb.length(); ind++){
                if(sb.charAt(ind)!=searchword.charAt(ind)) cnt++;
            }
            
            if(cnt==1) return true;
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */