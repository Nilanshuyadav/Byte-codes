class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start=0,end=0,max=0,n=s.length();
        HashSet<Character> set = new HashSet();
        
        while(start<n){
            if(!set.contains(s.charAt(start))){
                set.add(s.charAt(start));
                start++;
                max = Math.max(max,set.size());
            }
            else{
                set.remove(s.charAt(end));
                end++;
            }
        }
        return max;
        
        
        
    }
}