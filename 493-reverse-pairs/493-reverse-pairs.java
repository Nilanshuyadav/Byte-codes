class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        return merge_break(nums,temp,0,n-1);
    }
    
    private int merge_break(int[] arr,int[] temp, int low, int high){
        if(low>=high) return 0;
        
        int mid = (low + high)/2;
        
        int inv = merge_break(arr,temp,low,mid);
        inv += merge_break(arr,temp,mid+1,high);
        
        inv += merge(arr,temp,low,mid,high);
        
        return inv;
    }
    
    private int merge(int[] arr,int[] temp, int low, int mid, int high){
        int count = 0;
        int j = mid+1;
        
        for(int i=low;i<=mid;i++){
            while(j<=high && arr[i]>2*(long)arr[j]) j++;
            
            count += j-mid-1;
        }
        
        int left = low,right = mid+1,k = low;
        
        while(left<=mid && right<=high){
            if(arr[left]<arr[right]) temp[k++] = arr[left++];
            else temp[k++] = arr[right++];
        }
        
        while(left<=mid) temp[k++] = arr[left++];
        
        while(right<=high) temp[k++] = arr[right++];
        
        for(int i=low;i<=high;i++){
            arr[i] = temp[i];
        }
        
        return count;
    }
}