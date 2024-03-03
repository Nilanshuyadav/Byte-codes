class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        
        return mergeBreak(nums, 0, n-1);
    }
    
    public int mergeBreak(int[] arr, int l, int h){
        int sum = 0;
        if(l<h){
            int m = l + (h-l)/2;
            
            sum += mergeBreak(arr, l, m);
            sum += mergeBreak(arr, m+1, h);
            sum += merge(arr, l, m, h);
        }
        
        return sum;
    }
    
    public int merge(int[] arr, int l, int m, int h){
        int len = h-l+1, i=l, j=m+1, k=0, b=m+1, cnt=0;
        int[] temp = new int[len];
        
        for(int a=l; a<=m; a++){
            while(b<=h && (arr[a]>(2*((long)arr[b])))) b++;
            
            cnt += (b-m-1);
        }
        
        while(i<=m && j<=h){    
            if(arr[i]>=arr[j]){
                temp[k++] = arr[j++];
            }
            else{
                temp[k++] = arr[i++];
            }
        }
        
        while(i<=m){
            temp[k++] = arr[i++];
        }
        
        while(j<=h){
            temp[k++] = arr[j++];
        }
        
        for(int ind=0; ind<len; ind++){
            arr[ind+l] = temp[ind];
        }
        
        return cnt;
    }
}