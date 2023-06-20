class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        long toCompare = k*threshold;
        int n = arr.length, ind=0;
        long sum=0;
        int cnt=0;
        
        while(ind<n){
            if(ind<k-1){
                sum += arr[ind];        
            }
            else{
                sum += arr[ind];
                
                if(toCompare<=sum){
                    cnt++;
                }
                
                sum -= arr[ind-k+1];
            }
            
            ind++;
        }
        
        return cnt;
    }
}