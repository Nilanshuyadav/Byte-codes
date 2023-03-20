class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int m) {
        int n = flowerbed.length;
        boolean[] bool = new boolean[n];
        
        for(int ind=0; ind<n; ind++){
            if(flowerbed[ind] == 1){
                bool[ind] = true;
            }
        }
        
        int cnt=0;
        
        for(int ind=0; ind<n; ind++){
            if(bool[ind])
                continue;
            else if((ind!=0 && bool[ind-1]) || (ind!=n-1 && bool[ind+1]))
                continue;
            else{
                cnt++;
                bool[ind] = true;
            }
        }
        
        return cnt>=m;
    }
}