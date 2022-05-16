class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length == 1 && nums[0] == target) return 0;
        
        return bsearch(nums,0,nums.length-1,target);
    }
    
    private int bsearch(int[] nums,int low, int high,int target){
        
        if(low > high) return -1;
        
        int mid = (low + high)/2;
        
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return bsearch(nums, low,mid-1,target);
        else return bsearch(nums,mid+1, high,target);
    }
}