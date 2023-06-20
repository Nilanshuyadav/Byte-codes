class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int pre=0, n=nums.length;
        
        long min_curr=0, sum=0, cnt=0;
        
        for(int ind=0; ind<n; ind++){
            if(right<nums[ind]){
                sum -= ((min_curr)*(min_curr+1))/2;
                sum += ((cnt)*(cnt+1))/2;
                
                cnt=0;
                min_curr=0;
                
                continue;
            }
            else if(nums[ind] < left){
                min_curr++;
            }
            else{
                sum -= ((min_curr)*(min_curr+1))/2;
                
                min_curr = 0;
            }
            
            cnt++;
        }
        
        sum -= ((min_curr)*(min_curr+1))/2;
        sum += ((cnt)*(cnt+1))/2;
        
        return (int)sum;
    }
}