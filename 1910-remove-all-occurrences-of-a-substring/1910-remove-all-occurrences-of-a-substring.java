class Solution {
    public String removeOccurrences(String s, String part) {
     
        int n = part.length();
        StringBuilder ans = new StringBuilder(s);
        
        while(ans.indexOf(part) != -1){
            int start = ans.indexOf(part);
            ans.delete(start,start+n);
        }
        
        return ans.toString();
    }
}