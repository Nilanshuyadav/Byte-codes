class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int l=0, h=n-1, m;
        
        int[] temp = new int[n];
        
        for(int ind=0; ind<n; ind++)
            temp[ind] = nums[ind];
        
        Arrays.sort(temp);
        
        while(l<h){
            m = l + (h-l)/2;
            
            if(isPossible(temp[m], nums, k)) h=m;
            else l=m+1;
        }
        
        return temp[l];
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