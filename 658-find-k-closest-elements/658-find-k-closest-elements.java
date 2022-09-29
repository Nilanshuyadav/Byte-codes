class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int min_ind=0, min=Integer.MAX_VALUE, n = arr.length;
        int[] ar = new int[n];
        
        for(int ind=0; ind<n; ind++){
            int temp = Math.abs(arr[ind]-x);
            if(temp<min){
                min = temp;
                min_ind = ind;
            }
            
            ar[ind] = temp;
        }    
        
        Integer[] ans = new Integer[k];
        int curr=0;
        
        ans[curr++] = arr[min_ind];
        int low = min_ind-1, high = min_ind+1;
        
        while(low>=0 && high<n && curr<k){
            if(ar[low]>ar[high]) ans[curr++] = arr[high++];
            else ans[curr++] = arr[low--];
        }
        
        while(low>=0 && curr<k) ans[curr++] = arr[low--];
        while(high<n && curr<k) ans[curr++] = arr[high++];
        Arrays.sort(ans);
        
        return new ArrayList<>(Arrays.asList(ans));
    }
}