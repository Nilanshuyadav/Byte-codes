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
        
        int base = remSum/n;
        int remainder = remSum%n;
        
        for(int i=0; i<n; i++){
            res[i] = base;
            
            if(remainder-->0){
                res[i] += 1;
            }
        }
        
        return res;
    }
    
}