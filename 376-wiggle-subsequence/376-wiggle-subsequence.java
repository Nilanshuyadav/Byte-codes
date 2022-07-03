class Solution {
    public int wiggleMaxLength(int[] nums) {
      
        int n = nums.length;
        if(n == 1) return 1;
        
        int count = 1 , diff;
        boolean sign;
        
        int one = nums[0],j=1;
        
        while(j<n && nums[j] == one) j++;
        
        if(j == n) return 1;
        else diff = nums[j] - one;
        
        if(diff>0) sign = true;
        else sign =  false;
        
        for(int i = 1;i<n;i++){
            if(sign == true && nums[i] - nums[i-1]>0){
                count++;
                sign = false;
            }
            else if(sign == false && nums[i] - nums[i-1]<0){
                count++;
                sign = true;
            }    
            else if(sign == false && nums[i] - nums[i-1]>0)
                continue;
            else if(sign == true && nums[i] - nums[i-1]<0)
                continue;
            else continue;
        }
        return count;
        
    }
}