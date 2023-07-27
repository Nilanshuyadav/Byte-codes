class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        char ch;
        
        List<Character> al = new ArrayList<>();
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(isVowel(ch)){
                al.add(ch);    
            }
        }
        
        Collections.sort(al);
        
        StringBuilder sb = new StringBuilder("");
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(isVowel(ch)){
                sb.append(al.remove(0));
            }
            else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
    
    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ||
            ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U';
    }
}