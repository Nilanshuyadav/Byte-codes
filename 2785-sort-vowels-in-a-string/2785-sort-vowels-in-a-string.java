class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        Map<Character, Integer> map = new TreeMap<>();
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        
        char ch, temp_ch;
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(set.contains(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        
        
        
        StringBuilder sb = new StringBuilder("");
        List<Character> list = new ArrayList<>(map.keySet());
        int i=0;
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(set.contains(ch)){
                temp_ch = list.get(i);
                
                if(map.get(temp_ch)==0){
                    temp_ch = list.get(++i);
                }       
                
                sb.append(temp_ch);
                map.put(temp_ch, map.get(temp_ch)-1);
            }
            else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}