class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        
        Arrays.sort(piles);
        
        int sum = 0, ind=n/3;
        
        while(ind<n){
            sum += piles[ind];
            ind += 2;
        }
        
        return sum;
    }
}