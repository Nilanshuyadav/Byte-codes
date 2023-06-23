class Solution {
    public int addRungs(int[] rungs, int dist) {
        int curr=0;
        int n = rungs.length;
        
        int last = rungs[n-1];
        int cnt=0, ind=0;
        
        while(curr<last){
            if(rungs[ind]-curr <= dist){
                curr = rungs[ind++];
            }
            else{
                int temp = (rungs[ind]-curr-1)/dist;
                
                curr = curr + (dist*temp);
                cnt += temp;
            }
        }
        
        return cnt;
    }
}