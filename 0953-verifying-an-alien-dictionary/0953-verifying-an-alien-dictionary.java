class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        
        if(n==1)
            return true;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int ind=0; ind<26; ind++){
            map.put(order.charAt(ind), ind);
        }
        map.put(' ', -1);
        
        for(int ind=1; ind<n; ind++){
            if(pre_greater(new StringBuilder(words[ind-1]), new StringBuilder(words[ind]), map))
                return false;
        }
        
        return true;
    }
    
    public boolean pre_greater(StringBuilder pre, StringBuilder curr, Map<Character, Integer> map){
        int pre_len = pre.length(), curr_len = curr.length();
        
        if(pre_len<curr_len){
            int temp = curr_len-pre_len;
            while(temp-->0)
                pre.append(' ');
        }
        
        if(pre_len>curr_len){
            int temp = pre_len-curr_len;
            while(temp-->0)
                curr.append(' ');
        }
        
        for(int ind=0; ind<pre_len; ind++){
            if(pre.charAt(ind)!=curr.charAt(ind)){
                if(map.get(pre.charAt(ind)) > map.get(curr.charAt(ind)))
                    return true;
                else
                    break;
            }
        }
        
        return false;
    }
}