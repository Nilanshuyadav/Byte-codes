class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        return s.repeat(2).indexOf(goal)!=-1;
    }
}