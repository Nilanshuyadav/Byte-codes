class Solution {
    public int maxDistance(int[] position, int k) {
        int l=1, h = 1000000000, m;
        
        Arrays.sort(position);
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(canWe(position, m, k)){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return l-1;
    }
    
    public boolean canWe(int[] position, int m, int k){
        int cnt=1, pre=position[0];
        
        for(int i : position){
            if(i >= pre+m){
                pre = i;
                cnt++;
            }
        }
        
        return cnt>=k;
    }
}