class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int i=0, j=tokens.length-1;
        int score=0, max=0;
        
        while(i<=j){
            while(i<=j && tokens[i]<=power){
                power -= tokens[i];
                score++;
                i++;
            }    
            
            max = Math.max(max, score);
            
            if(i<=j && score>0){
                score--;
                power += tokens[j];
                j--;
            }
            else{
                break;
            }
        }
        
        return max;
    }
}