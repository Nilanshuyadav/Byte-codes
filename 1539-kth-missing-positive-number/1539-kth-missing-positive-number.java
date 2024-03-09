class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0, h=arr.length-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(arr[m]-m-1 >= k)h = m-1;
            else l = m+1;
        }
        
        return k+h+1;
    }
}