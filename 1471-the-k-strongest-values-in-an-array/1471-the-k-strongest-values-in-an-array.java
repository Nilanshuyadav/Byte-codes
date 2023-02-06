class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int[] ans = new int[k];
        int inx = 0;
        
        Arrays.sort(arr);
        
        int n = arr.length;
        int median = (arr[(n-1)/2]);
        
        int l=0, h=n-1, low, high;
        
        while(k-->0){
            low = Math.abs(arr[l]-median);
            high = Math.abs(arr[h]-median);
            if(low > high){
                ans[inx++] = arr[l++];
            }    
            else if(low<=high){
                ans[inx++] = arr[h--];
            }
        }
        
        return ans;
    }
}