class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int l=1, max=0, h=max, m;
        
        for(int ind=0; ind<n; ind++)
            max = Math.max(max, nums[ind]);
        
        h = max;
        
        while(l<h){
            m = l + (h-l)/2;
            
            if(isPossible(m, nums, k)) h=m;
            else l=m+1;
        }
        
        return l;
    }
    
    public boolean isPossible(int inx, int[] nums, int k){
        int start=0, last_picked=-2, cnt=0;
        
        for(int ind=0; ind<nums.length; ind++){
            if(nums[ind]>inx) continue;
            if(last_picked==ind-1) continue;
            
            cnt++;
            last_picked = ind;
        }
        
        return cnt>=k;
    }
}