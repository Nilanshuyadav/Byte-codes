class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        
        int l=1, h=arr[n-1]+k, m;
        int pos;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            pos = findPos(m, arr);
            
            if(pos > k) h = m-1;
            else l = m+1;
        }
        
        return l-1;
    }
    
    public int findPos(int m, int[] arr){
        int cnt=0;
        
        for(int i : arr){
            if(i<m){
                cnt++;
            }
        }
        
        return m-cnt;
    }
}