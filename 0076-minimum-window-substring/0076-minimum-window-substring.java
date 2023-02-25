class Solution {
    public String minWindow(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        
        char ch;
        int[] fre = new int[58];
        for(int ind=0; ind<t.length(); ind++){
            ch = t.charAt(ind);
            
            if(!map.containsKey(ch))
                map.put(ch, new ArrayList<>());
            
            fre[ch-'A']++;
        }
        
        int min, ans=Integer.MAX_VALUE, al_size;
        int[] st = new int[]{-1, -1};
        List<Integer> al;
        
        for(int ind=0; ind<s.length(); ind++){
            ch = s.charAt(ind);
            
            if(!map.containsKey(ch))
                continue;
            
            map.get(ch).add(ind);
            
            min = Integer.MAX_VALUE;
            for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
                ch = entry.getKey();
                al = entry.getValue();
                
                al_size = al.size();
                
                if(al_size-fre[ch-'A'] < 0){
                    min = -1;
                    break;
                }
                else{
                    min = Math.min(min, al.get(al_size - fre[ch-'A']));
                }
            }
            
            if(min!=-1 && (ind-min+1)<ans){
                ans = (ind - min + 1);
                st[0] = min;
                st[1] = ind+1;
            }
        }
        
        return st[0]==-1 ? "" : s.substring(st[0], st[1]);
    }
}