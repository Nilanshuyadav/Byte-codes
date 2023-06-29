class Solution {
    public String minWindow(String s, String t) {
        int s_len = s.length(), t_len = t.length();
        int[] fre = new int[58];
        Map<Character, List<Integer>> map = new HashMap<>();
        
        char ch;
        for(int ind=0; ind<t_len; ind++){
            ch = t.charAt(ind);
            fre[ch-'A']++;
            
            map.putIfAbsent(ch, new ArrayList<>());
        }
        
        int min, temp, min_len=(int)1e8;
        String ans="";
        List<Integer> al;
        
        for(int ind=0; ind<s_len; ind++){
            ch = s.charAt(ind);
            
            if(!map.containsKey(ch)){
                continue;
            }
            
            map.get(ch).add(ind);
            
            min = ind;
            
            for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
                ch = entry.getKey();
                al = entry.getValue();
                
                if(al.size()<fre[ch-'A']){
                    min = -1;
                    break;
                }
                
                min = Math.min(min, al.get(al.size()-fre[ch-'A']));
            }
            
            if(min == -1){
                continue;
            }
            
            temp = ind-min+1;
            
            if(temp < min_len){
                min_len = temp;
                ans = s.substring(ind-temp+1, ind+1);
            }
        }
        
        return ans;
    }
}