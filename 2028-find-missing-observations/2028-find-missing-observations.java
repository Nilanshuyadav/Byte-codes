class Solution {
    int[] res;
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        
        int sum = mean*(m+n),
            msum = 0;
        
        for(int i : rolls) msum += i;
        
        int remSum = sum - msum;
        int min = n, 
            max = (n*6);
        
        if(remSum<min || max<remSum) return new int[0];
        
        res = new int[n];
        
        for(int i=0; i<n; i++){
            if((n-1-i)<=(remSum-6)){
                res[i] = 6;
                remSum -= 6;
            }
            else if((n-1-i)<=(remSum-5)){
                res[i] = 5;
                remSum -= 5;
            }
            else if((n-1-i)<=(remSum-4)){
                res[i] = 4;
                remSum -= 4;
            }
            else if((n-1-i)<=(remSum-3)){
                res[i] = 3;
                remSum -= 3;
            }
            else if((n-1-i)<=(remSum-2)){
                res[i] = 2;
                remSum -= 2;
            }
            else{
                res[i] = 1;
                remSum -= 1;
            }
        }
        
        return res;
    }
    
}