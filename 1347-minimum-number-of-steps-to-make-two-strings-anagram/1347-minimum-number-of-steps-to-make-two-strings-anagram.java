class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        int s_len = s.length(), t_len = t.length();
        
        for(int ind=0; ind<s_len; ind++){
            map.put(s.charAt(ind), map.getOrDefault(s.charAt(ind), 0) + 1);
        }
        
        int cnt=0;
        for(int ind=0; ind<t_len; ind++){
            if(map.containsKey(t.charAt(ind))){
                if(map.get(t.charAt(ind)) > 1){
                    map.put(t.charAt(ind), map.get(t.charAt(ind))-1);
                }
                else{
                    map.remove(t.charAt(ind));
                }
            }
            else{
                cnt++;
            }
        }
        
        return cnt;
    }
}