class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0; i<s.length(); i++){
            sb.append(String.valueOf(s.charAt(i)-'a'+1));
        }
        
        String num = sb.toString();
        int curr=0;
        while(k-->0){
            curr = 0;
            
            for(int i=0; i<num.length(); i++){
                curr += (num.charAt(i)-'0');
            }
            
            num = String.valueOf(curr);
        }
        
        return curr;
    }
}