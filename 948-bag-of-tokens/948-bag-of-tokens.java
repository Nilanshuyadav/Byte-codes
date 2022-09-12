class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0,low = 0, high = tokens.length-1,ans = 0;
        
        while(low<=high){
            if(tokens[low]<=power){
                power -= tokens[low];
                score += 1;
                ans = Math.max(ans,score);
                low++;
            }
            else if(score>0){
                power += tokens[high];
                score -= 1;
                ans = Math.max(ans,score);
                high--;
            }
            else break;
        }
        return ans;
    }
}