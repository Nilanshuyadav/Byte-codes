class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length, index1 = firstOcc(nums, target);
        
        if(index1==n || nums[index1]!=target) return new int[]{-1, -1};
        
        
        int index2 = lastOcc(nums, target)-1;
        
        return new int[]{index1, index2};
    }
    
    public int lastOcc(int[] arr, int target){
        int l=0, h=arr.length-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(arr[m] <= target) l = m+1;
            else h = m-1;
        }
        
        return l;
    }
    
    public int firstOcc(int[] arr, int target){
        int l=0, h=arr.length-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(arr[m] >= target) h = m-1;
            else l = m+1;
        }
        
        return h+1;
    }
}