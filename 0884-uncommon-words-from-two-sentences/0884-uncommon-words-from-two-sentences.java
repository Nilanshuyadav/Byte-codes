class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> set = new HashSet<>(), bl = new HashSet<>();
        String[] ar1 = s1.split(" "), ar2 = s2.split(" ");
        
        for(String s : ar1){
            if(!bl.contains(s) && !set.add(s)){
                set.remove(s);
                bl.add(s);
            }
        }
        for(String s : ar2){
            if(!bl.contains(s) && !set.add(s)){
                set.remove(s);
                bl.add(s);
            }
        }
        
        int n = set.size();
        String[] ans = new String[n];
        int ind=0;
        
        for(String s : set){
            ans[ind++] = s;
        }
        
        return ans;
    }
}