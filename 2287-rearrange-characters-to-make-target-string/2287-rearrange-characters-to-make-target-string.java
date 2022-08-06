class Solution {
    public int rearrangeCharacters(String s, String target) {
         Map<Character,Integer> map = new HashMap<>();
        
        StringBuilder st = new StringBuilder(s);
        
        for(int i=0;i<st.length();i++){
            map.put(st.charAt(i),map.getOrDefault(st.charAt(i),0)+1);
        }
        
        StringBuilder tt = new StringBuilder(target);
        
        int count = 0;
        
        while(true){
            
        for(int i=0;i<tt.length();i++){
            if(map.containsKey(tt.charAt(i))){
                int n = map.get(tt.charAt(i));{
                    if(n == 0) return count;
                }
                map.put(tt.charAt(i),n-1);
            }
            
            else return count;
        }
        
        count++;
        }
        
}
}