class MagicDictionary {

    Set<String> al;
    public MagicDictionary() {
        al = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s: dictionary)
            al.add(s);
    }
    
    public boolean search(String searchWord) {

        StringBuilder ss = new StringBuilder(searchWord);
        
        for(String st : al){
            StringBuilder sb = new StringBuilder(st);
            int cnt=0;
            
            if(sb.length() != ss.length()) continue;
            
            for(int ind=0; ind<sb.length(); ind++)
                if(sb.charAt(ind) != ss.charAt(ind)) cnt++;
            
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