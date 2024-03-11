class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        
        List<String> al = new ArrayList<>();
        
        StringBuilder sb;
        for(int ind=0; ind<n; ){
            sb = new StringBuilder("");
            
            while(ind<n && s.charAt(ind)!=' '){
                sb.append(s.charAt(ind++));
            }
            
            al.add(sb.toString());
            
            while(ind<n && s.charAt(ind) == ' '){
                ind++;
            }
        }
        
        int l=0, h=al.size()-1;
        String str;
        
        while(l<h){
            str = al.get(l);
            al.set(l, al.get(h));
            al.set(h, str);
            
            l++;
            h--;
        }
        
        sb = new StringBuilder("");
        
        for(String st : al){
            sb.append(" ");
            sb.append(st);
        }
        
        return sb.substring(1);
    }
}