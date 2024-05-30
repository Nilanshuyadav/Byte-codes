class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length()==goal.length() && s.repeat(2).indexOf(goal)!=-1;
    }
}