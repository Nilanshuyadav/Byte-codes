class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        
        int position = -1;
        position = startingPosition(0,nums.length-1,target,nums);
        
        if(position == -1) return new int[]{-1,-1};
        System.out.println(position);
        
        int j = position, i = position;
        
        while(i >= 1 && nums[i] == nums[i-1]) i--;
        while(j < nums.length-1 && nums[j] == nums[j+1]) j++;
        
        return new int[]{i,j};
        
    }
    
    public int startingPosition(int low, int high, int target, int[] nums){
        
        if(low > high) return -1;
        
        int mid = (low + high)/2;
        
        if(nums[mid] == target) return mid;
        
        else if(nums[mid] > target) return startingPosition(low,mid-1,target,nums);
        
        else return startingPosition(mid+1,high,target,nums);
    }
}