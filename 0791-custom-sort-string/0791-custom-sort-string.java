class Solution {
    public String customSortString(String order, String s) {
        int o_len = order.length(), s_len = s.length(), times;
        char ch;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s_len; i++){
            ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<o_len; i++){
            ch = order.charAt(i);
            
            if(map.containsKey(ch)){
                times = map.get(ch);
                
                while(times-->0){
                    sb.append(ch);
                }
                
                map.remove(ch);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            times = entry.getValue();
            
            while(times-->0){
                sb.append(entry.getKey());
            }
        }
        
        return sb.toString();
    }
}