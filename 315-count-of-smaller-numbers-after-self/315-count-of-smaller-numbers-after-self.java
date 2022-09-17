class Solution {
    
    Integer[] ans;
    
    public List<Integer> countSmaller(int[] arr) {
        int n = arr.length;
        
        Pair[] nums = new Pair[n];
        
        for(int i =0;i<n;i++){
            nums[i] = new Pair(arr[i],i);
        }
        
        
        
        ans = new Integer[n];
        Arrays.fill(ans,0);
        
        mergeSort(nums,0,n-1);
        
        List<Integer> l = new ArrayList<>(Arrays.asList(ans));
        
        return l;
    }
    
    public void mergeSort(Pair[] nums, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            
            merge(nums,left,mid,right);
        }
    }
    
    public void merge(Pair[] nums,int left, int mid, int right){
        int n = (mid - left + 1) + (right - mid);
        
        Pair[] temp = new Pair[n];
        
        int i = left, j = mid+1, k = 0;
        
        while(i <= mid && j<=right){
            if(nums[i].val > nums[j].val){
                ans[nums[i].ind] += right-j+1;
                temp[k] = nums[i];
                i++;
            }
            
            else{
                temp[k] = nums[j];
                j++;
            }
           
            k++;
        }
        
        while(i <= mid){
            temp[k] = nums[i];
            k++;
            i++;
        }
        
        while(j <= right){
            temp[k] = nums[j];
            k++;
            j++;
        }
        
        for(int a = left;a<=right;a++){
            nums[a] = temp[a - left];
        }
        
    }
}

class Pair{
    int val;
    int ind;
    
    public Pair(int val, int ind){
        this.val = val;
        this.ind = ind;
    }
}