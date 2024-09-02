class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int n = chalk.length;
        for(int i : chalk){
            sum += i;
        }
        
        k %= sum;
        
        for(int i=0; i<n; i++){
            if(k<chalk[i]){
                return i;
            }
            
            k -= chalk[i];
        }
        
        return 0;
    }
}