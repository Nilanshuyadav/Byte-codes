class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] arr = new int[n];
        
        for(int ind=1; ind<n; ind++){
            arr[ind] = weights[ind-1]+weights[ind];
        }
        
        Arrays.sort(arr);
        
        long max_sum=0, min_sum=0;
        int max=n-1, min=1;
        
        while(k-->1){
            max_sum += arr[max--];
            min_sum += arr[min++];
        }
        
        return max_sum - min_sum;
    }
}