class Solution {
    public String largestOddNumber(String num) {
        
        int max=-1, temp;
        for(char i='1'; i<='9'; i+=2){
            max = Math.max(max, num.lastIndexOf(i));
        }
        
        return num.substring(0, max+1);
    }
}