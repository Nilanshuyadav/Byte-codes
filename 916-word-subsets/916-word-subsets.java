class Solution {
    Map<Character,Integer> words2_map = new HashMap<>();
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length, m= words2.length;
        int cnt = 0;
        
        int[] arr = new int[26];
        
        for(String s:words2){
            for(char ch : s.toCharArray()){
                arr[ch - 'a']++;
                words2_map.put(ch,Math.max(words2_map.getOrDefault(ch,0),arr[ch-'a']));
            }
            Arrays.fill(arr,0);
        }
        
        
        List<String> ans = new ArrayList<>();
        
        for(String s : words1){
            if(check(s))
                ans.add(s);
        }
        
        return ans;
    }
    
    public boolean check(String s){
        Map<Character,Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        
        for(Map.Entry<Character,Integer> entry : words2_map.entrySet()){
            if(map.containsKey(entry.getKey()) && map.get(entry.getKey())>=entry.getValue()) continue;
            else return false;
        }
        
        return true;
    }
}