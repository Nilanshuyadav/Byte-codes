class Solution {
    public int maxScore(String s) {
        int cnt_zero = 0, cnt_one = 0, sum = 0, max = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1') cnt_one++;
        }

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='0') cnt_zero++;
            else cnt_one--;

            sum = cnt_zero + cnt_one;
            max = Math.max(sum, max);
        }

        return max;
    }
}