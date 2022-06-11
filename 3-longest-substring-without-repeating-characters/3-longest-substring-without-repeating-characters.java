class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int len = 0;
        int max = 0;
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(int right=0;right<n;right++){
            char ch = s.charAt(right);
            
            if(map.containsKey(ch) && map.get(ch)<=right && map.get(ch)>=left){
                left = map.get(ch)+1;
                map.put(ch,right);
                
                len = right-left+1;
            }
            else {
                map.put(ch,right);
                len = right-left+1;
            }
            
            max = Math.max(len,max);
        }
        
        return max;
    }
}