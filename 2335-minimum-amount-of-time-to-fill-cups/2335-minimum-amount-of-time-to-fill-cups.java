class Solution {
    public int fillCups(int[] amount) {
        
        int max = 0,sum = 0;
        
        for(int a :amount){
            max = Math.max(a,max);
            sum += a;
        }
        
        return Math.max(max,(sum+1)/2);
    }
}