class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1_len = s1.length(), s2_len = s2.length(), s3_len = s3.length();
        
        return solve(0, 0, 0, s1, s2, s3, s1_len, s2_len, s3_len, new HashSet<>());
    }
    
    public boolean solve(int i, int j, int ind, String s1, String s2, String s3, int s1_len, int s2_len, int s3_len, Set<String> set){
        if(ind == s3_len){
            return i==s1_len && j==s2_len;
        }
        
        String st = ""+ind+","+i+","+j;
        
        if(set.contains(st)){
            return false;
        }
        
        set.add(st);
        
        boolean bool = false;
        
        if(i<s1_len && s3.charAt(ind)==s1.charAt(i)){
            bool |= solve(i+1, j, ind+1, s1, s2, s3, s1_len, s2_len, s3_len, set);
        }
        
        if(j<s2_len && s3.charAt(ind)==s2.charAt(j)){
            bool |= solve(i, j+1, ind+1, s1, s2, s3, s1_len, s2_len, s3_len, set);
        }
        
        return bool;
    }
}