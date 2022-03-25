class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
                   
        String[] array = s.split(" ");
        int m = array.length;
        
        if(n != m) return false;
        
        Map<Character,String> map = new HashMap();
        Map<String,Character> map2 = new HashMap();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(array[i])) return false;
            }
            
            if(map2.containsKey(array[i])){
                if(map2.get(array[i]) != pattern.charAt(i)) return false;
            }
            
            map.put(pattern.charAt(i),array[i]);
            map2.put(array[i],pattern.charAt(i));
        }
        
        return true;
    }
}